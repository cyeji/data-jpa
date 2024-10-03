package com.yeji.datajpa;

import org.springframework.boot.SpringApplication;

public class TestDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.from(DataJpaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
