package com.task.expensemanager.service;

import com.task.expensemanager.entity.Role;

public interface RoleService {

    Role save(Role role);

    void addRoleToUser(String username, String roleName);
}
