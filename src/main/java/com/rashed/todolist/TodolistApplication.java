package com.rashed.todolist;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rashed.todolist.entity.Task;
import com.rashed.todolist.repository.TaskRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TodolistApplication implements CommandLineRunner {

	TaskRepository taskRepository;

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task[] tasks = new Task[] {
				new Task(1L, "eat", "eat apples and mansaf", LocalDateTime.of(2025, 7, 31, 12, 0, 0), false),
				new Task(2L, "study", "study math apples and mansaf", LocalDateTime.of(2025, 7, 2, 12, 0, 0),
						false),
				new Task(3L, "play", "play soccer", LocalDateTime.of(2025, 7, 30, 12, 0, 0), false)
		};

		for (int i = 0; i < tasks.length; i++) {
			taskRepository.save(tasks[i]);
		}
	}
}
