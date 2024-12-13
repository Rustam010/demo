package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ConditionalOnBeanTests.Config.class)
class ConditionalOnBeanTests {

    @Configuration
    static class Config {
        @Bean
        public String myBean() {
            return "Existing Bean";
        }

        @Bean
        @ConditionalOnBean(name = "myBean")
        public String conditionalBean() {
            return "Conditional Bean";
        }
    }

    @Autowired(required = false)
    private String conditionalBean;

    @Test
    void testConditionalBean() {
        assertThat(conditionalBean).isEqualTo("Conditional Bean");
    }
}
