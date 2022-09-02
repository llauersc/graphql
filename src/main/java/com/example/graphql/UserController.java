package com.example.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

  @MutationMapping
  User addUser(@Argument UserInput user) {
    return userRepository.save(User.builder()
      .name(user.name())
      .email(user.email())
      .build());
  }

  record UserInput(String name, String email) {}
}
