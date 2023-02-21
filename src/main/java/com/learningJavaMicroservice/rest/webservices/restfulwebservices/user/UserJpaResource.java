package com.learningJavaMicroservice.rest.webservices.restfulwebservices.user;

import com.learningJavaMicroservice.rest.webservices.restfulwebservices.post.Post;
import com.learningJavaMicroservice.rest.webservices.restfulwebservices.post.PostJpaRepository;
import com.learningJavaMicroservice.rest.webservices.restfulwebservices.jpa.UserJpaRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private final UserJpaRepository userJpaRepository;
    private final PostJpaRepository postJpaRepository;

    public UserJpaResource(UserJpaRepository userJpaRepository, PostJpaRepository postJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.postJpaRepository = postJpaRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return this.userJpaRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id) {
        Optional<User> user = this.userJpaRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id ) {
        this.userJpaRepository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = this.userJpaRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id ) {
        Optional<User> user = this.userJpaRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        List<Post> posts = user.get().getPosts();
        return posts;
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @RequestBody Post post ) {
        Optional<User> user = this.userJpaRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        post.setUser(user.get());
        Post savedPost = this.postJpaRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
