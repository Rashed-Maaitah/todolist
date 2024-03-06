package com.rashed.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rashed.todolist.entity.Task;
import com.rashed.todolist.exception.EntityNotFoundException;
import com.rashed.todolist.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Task getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return unwrapTask(task, id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTask(id);
        task.setCompleted(updatedTask.isCompleted());
        task.setDescription(updatedTask.getDescription());
        task.setName(updatedTask.getName());
        task.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, Task.class);
    }

}
