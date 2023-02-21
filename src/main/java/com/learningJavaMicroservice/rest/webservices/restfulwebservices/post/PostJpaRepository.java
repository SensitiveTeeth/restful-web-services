package com.learningJavaMicroservice.rest.webservices.restfulwebservices.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Integer> {
}
