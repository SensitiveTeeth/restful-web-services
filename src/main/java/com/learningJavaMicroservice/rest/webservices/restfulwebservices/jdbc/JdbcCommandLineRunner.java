package com.learningJavaMicroservice.rest.webservices.restfulwebservices.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JdbcCommandLineRunner implements CommandLineRunner {
    private final JdbcRepository repository;

    public JdbcCommandLineRunner(JdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.insert(new Course(1, "Learn AWS", "here"));
        this.repository.insert(new Course(2, "Learn GCP", "here"));
        this.repository.insert(new Course(3, "Learn Azure", "here"));

        this.repository.deleteById(1);
        System.out.println(this.repository.findById(2));
        System.out.println(this.repository.findById(3));
    }
}
