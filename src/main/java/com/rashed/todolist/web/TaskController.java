package com.rashed.todolist.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rashed.todolist.entity.Task;
import com.rashed.todolist.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
@Tag(name = "Task Controller", description = "Create, update and read simple task for the todo-list")
public class TaskController {
    TaskService taskService;

    @Operation(summary = "Get task by id", description = "Returns a task based on an id")
    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        String response = task.getName() + " " + task.getDescription() + " " + task.getDueDate();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Create task", description = "Creates task from the provided payload")
    @PostMapping
    public ResponseEntity<HttpStatus> createTask(@Valid @RequestBody Task task) {
        taskService.saveTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieves tasks", description = "Returns a list of all tasks")
    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @Operation(summary = "Update task", description = "Updates task based on id with the provided payload")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @Operation(summary = "Delete task", description = "Deletes task based on an id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
