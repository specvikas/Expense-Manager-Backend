package com.task.expensemanager.service;

import com.task.expensemanager.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findByUsername(String username);

    List<User> getUsers();
}
