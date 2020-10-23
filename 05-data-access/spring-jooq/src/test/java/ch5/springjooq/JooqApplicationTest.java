package ch5.springjooq;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JooqApplicationTest {

    @Autowired
    private DSLContext dsl;

    @Test
    void insert(){

    }

}