package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ScopeTest {

    @Autowired
    private ApplicationContext context; // Контекст для доступа к бинам

    @Test
    public void testScope() {
        // Получаем два бина MyService из контекста
        MyService service1 = context.getBean(MyService.class);
        MyService service2 = context.getBean(MyService.class);

        // Проверяем, что они не одинаковы (для prototype scope)
        assertNotSame(service1, service2);
    }
}
