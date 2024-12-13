package com.example.demo;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@PropertySource("classpath:application.properties")
@Import(AdditionalConfig.class)
public class AppConfig {

    @Value("${app.property}")
    private String appProperty;

    @Bean
    @Scope("prototype")
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    @Lazy
    public AnotherService anotherService() {
        return new AnotherService();
    }

    @Bean
    @Primary
    public MyService primaryService() {
        return new MyServiceImpl();
    }

    @Bean
    @DependsOn("anotherService")
    public ThirdService thirdService() {
        return new ThirdService();
    }
}
