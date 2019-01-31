package jdbcapp.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * -------------------------------------------------------------------------------
 * Spring JDBC Data Access
 * -------------------------------------------------------------------------------
 * # JdbcTemplate - query, queryForObject, update, execute
 * # NamedParameterJdbcTemplate - ':param'
 * # SimpleJdbcCall - call stored procedures
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
    private RowMapper<ToDo> rowMapper = null;

    public Collection<ToDo> findAll() {
        return toDoCache.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparing(ToDo::getCreated))
                .collect(Collectors.toList());
    }

    public ToDo findById(final String id) {
        return toDoCache.get(id);
    }

    // create or update
    public ToDo save(final ToDo toDo) {
        final ToDo existing = toDoCache.get(toDo.getId());
        if (existing == null) {
            toDoCache.put(toDo.getId(), toDo);
            return toDo;
        }
        existing.setDescription(toDo.getDescription());
        existing.setModified(LocalDateTime.now());
        existing.setCompleted(toDo.getCompleted());
        return existing;
    }

    public Collection<ToDo> saveAll(final Collection<ToDo> toDos) {
        toDos.forEach(this::save);
        return findAll();
    }

    public void delete(ToDo toDo) {
        toDoCache.remove(toDo);
    }

}
