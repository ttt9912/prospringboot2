package ch5.springjooq;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.generated.tables.Todo;
import org.jooq.generated.tables.records.TodoRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class JooqApplicationTest {

    @Autowired
    private DSLContext dsl;

    @Test
    void findAll() {
        final Result<Record> fetch = dsl.select()
                .from(Todo.TODO)
                .fetch();
    }

    @Test
    void insert() {
        final TodoRecord todoRecord = dsl.newRecord(Todo.TODO);
        todoRecord.setId("123");
        todoRecord.setDescription("Read me with JOOQ");
        todoRecord.setCompleted((byte) 0);
        todoRecord.setCreated(LocalDateTime.now());
        todoRecord.setModified(LocalDateTime.now());
        todoRecord.store();
    }


}