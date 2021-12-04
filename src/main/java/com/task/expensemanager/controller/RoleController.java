package com.task.expensemanager.controller;

import com.task.expensemanager.entity.Role;
import com.task.expensemanager.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        log.info("Role at Controller : {}", role);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleService.save(role));
    }

    @PutMapping("/{roleName}/add/to/user/{username}")
    public ResponseEntity<?> addRoleToUser(
            @PathVariable("roleName") String roleName, @PathVariable("username") String username) {
        roleService.addRoleToUser(username, roleName);
        return ResponseEntity.ok().build();
    }
}
