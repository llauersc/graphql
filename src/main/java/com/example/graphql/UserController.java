package com.example.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
  
  private final UserRepository userRepository;

  @QueryMapping
  Iterable<User> users() {
    return userRepository.findAll();
  }

  @QueryMapping
  User user(@Argument Long id) {
    return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
  }
}
