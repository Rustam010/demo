package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnnotationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testPrimary() {
        MyService service = context.getBean(MyService.class);
        assertTrue(service instanceof MyServiceImpl);
    }

    @Test
    public void testLazy() {
        AnotherService service = context.getBean(AnotherService.class);
        assertNotNull(service);
    }

    @Test
    public void testDependsOn() {
        ThirdService service = context.getBean(ThirdService.class);
        assertNotNull(service);
    }
}
