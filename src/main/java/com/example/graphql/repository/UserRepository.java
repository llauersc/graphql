package com.example.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
