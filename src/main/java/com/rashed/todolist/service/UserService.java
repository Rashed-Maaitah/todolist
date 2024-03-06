package com.rashed.todolist.service;

import com.rashed.todolist.entity.User;

public interface UserService {
    User getUser(Long id);

    User getUser(String username);

    User saveUser(User user);

}