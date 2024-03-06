package com.rashed.todolist.service;

import java.util.List;

import com.rashed.todolist.entity.Task;

public interface TaskService {
    Task getTask(Long id);

    Task saveTask(Task task);

    void deleteTask(Long id);

    Task updateTask(Long id, Task updatedTask);

    List<Task> getTasks();

}