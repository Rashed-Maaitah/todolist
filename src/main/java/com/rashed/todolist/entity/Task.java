package com.rashed.todolist.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @NotNull
    @Column(name = "description", nullable = true)
    private String description;

    @NotNull
    @Future(message = "Due date cannot be in the past")
    @Column(name = "dueDate", nullable = false)
    private LocalDateTime dueDate;

    @NotNull
    @Column(name = "completed", nullable = false)
    private boolean completed;

}
