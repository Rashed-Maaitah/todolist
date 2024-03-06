package com.rashed.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.rashed.todolist.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
