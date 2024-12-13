package com.example.demo;

public class AnotherService implements MyService {
    @Override
    public void execute() {
        System.out.println("Executing AnotherService");
    }
}