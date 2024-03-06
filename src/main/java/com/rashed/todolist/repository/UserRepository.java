package com.rashed.todolist.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rashed.todolist.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
	// boolean existsByUsername(String username);
}