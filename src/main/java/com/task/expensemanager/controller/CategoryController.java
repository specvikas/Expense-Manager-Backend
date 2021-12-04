package com.task.expensemanager.controller;

import com.task.expensemanager.entity.Category;
import com.task.expensemanager.service.implementation.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/category/create").toUriString());
        return ResponseEntity.created(uri).body(categoryService.save(category));
    }

    @GetMapping("/created-by/user/{username}")
    public ResponseEntity<List<Category>> findCategoriesCreatedByUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(categoryService.findByUser(username));
    }
}
