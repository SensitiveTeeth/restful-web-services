package com.learningJavaMicroservice.rest.webservices.restfulwebservices.jpa;

import com.learningJavaMicroservice.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
