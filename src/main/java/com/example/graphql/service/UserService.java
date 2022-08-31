package com.example.graphql.service;

import org.springframework.stereotype.Service;

import com.example.graphql.entity.User;
import com.example.graphql.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException());
  }
}
