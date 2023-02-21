package com.learningJavaMicroservice.rest.webservices.restfulwebservices.Post;

import com.learningJavaMicroservice.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Integer> {
}
