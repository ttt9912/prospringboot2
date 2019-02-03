package jdbcapp.data;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * -------------------------------------------------------------------------------
 * Spring JDBC Data Access
 * -------------------------------------------------------------------------------
 * # JdbcTemplate
 *      - query
 *      - queryForObject
 *      - update
 *      - execute
 *
 * # NamedParameterJdbcTemplate - ':param'
 *
 * # SimpleJdbcCall - call stored procedures
 *
 * # RowMapper - mappinf rows of the ResultSet
 */
@Repository
public class ToDoRepository {
    private static final String SQL_INSERT = "insert into todo (id, description, created, modified, completed) " +
            "values(:id, :description, :created, :modified, :completed)";
    private static final String SQL_FIND_ALL = "select id,description, created, modified, completed from todo";
    private static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where id = :id";
    private static final String SQL_UPDATE = "update todo " +
            "set description = :description, modified = :modified, completed = :completed " +
            "where id = :id";
    private static final String SQL_DELETE = "delete from todo where id = :id";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ToDoRepository(final JdbcTemplate jdbcTemplate, final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /*
     * RowMapper implementation - map ResultSet to Entity
     */
    private RowMapper<ToDo> toDoRowMapper = (ResultSet rs, int row) -> new ToDo(
            rs.getString("id"),
            rs.getString("description"),
            rs.getTimestamp("created").toLocalDateTime(),
            rs.getTimestamp("modified").toLocalDateTime(),
            rs.getBoolean("completed")
    );

    /*
     * queryForObject - with RowMapper argument
     */
    public ToDo findById(String id) {
        try {
            Map<String, String> namedParameters = Collections.singletonMap("id", id);
            return this.namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID,
                    namedParameters, toDoRowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Iterable<ToDo> findAll() {
        return this.jdbcTemplate.query(SQL_FIND_ALL, toDoRowMapper);
    }

    public void delete(final ToDo domain) {
        Map<String, String> namedParameters = Collections.
                singletonMap("id", domain.getId());
        this.jdbcTemplate.update(SQL_DELETE, namedParameters);
    }

    public ToDo save(final ToDo toDo) {
        ToDo result = findById(toDo.getId());
        if (result != null) {
            result.setDescription(toDo.getDescription());
            result.setCompleted(toDo.getCompleted());
            result.setModified(LocalDateTime.now());
            return upsert(result, SQL_UPDATE);
        }
        return upsert(toDo, SQL_INSERT);
    }

    /*
     * NamedParameterJdbcTemplate - update
     */
    private ToDo upsert(final ToDo toDo, final String sql) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("id", toDo.getId());
        namedParameters.put("description", toDo.getDescription());
        namedParameters.put("created", java.sql.Timestamp.valueOf(toDo.getCreated()));
        namedParameters.put("modified", java.sql.Timestamp.valueOf(toDo.getModified()));
        namedParameters.put("completed", toDo.getCompleted());
        this.namedParameterJdbcTemplate.update(sql, namedParameters);
        return findById(toDo.getId());
    }
}
