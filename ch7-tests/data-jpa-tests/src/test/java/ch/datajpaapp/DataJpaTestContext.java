package ch.datajpaapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTestContext {

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        System.out.println("Beans of Type @RestController - " + context.getBeansOfType(RestController.class));
        System.out.println("Beans of Type @Entity - " + context.getBeansOfType(Entity.class));
        System.out.println("Beans of Type CrudRepository - " + context.getBeansOfType(CrudRepository.class));
    }
}
