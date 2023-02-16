package com.learningJavaMicroservice.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service

    public UserResource(UserDaoService service) {
        this.service = service;
    }
    public List<User> retrieveAllUsers() {

    }
}
