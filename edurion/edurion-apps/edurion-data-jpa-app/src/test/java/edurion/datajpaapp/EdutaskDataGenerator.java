package edurion.datajpaapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edurion.business.edutask.Edutask;
import edurion.business.edutask.EdutaskFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EdutaskDataGenerator {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createJson() throws JsonProcessingException {
        Edutask clean_architecture = EdutaskFactory.createEdutask("Clean Architecture");
        Edutask implementing_ddd = EdutaskFactory.createEdutask("Implementing DDD");

        System.out.println(objectMapper.writeValueAsString(clean_architecture));
        System.out.println(objectMapper.writeValueAsString(implementing_ddd));
    }

}