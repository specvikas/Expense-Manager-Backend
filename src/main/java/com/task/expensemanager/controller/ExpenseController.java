package com.task.expensemanager.controller;

import com.task.expensemanager.entity.Expense;
import com.task.expensemanager.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/expense/add").toUriString());
        return ResponseEntity.created(uri).body(expenseService.save(expense));
    }

    @PatchMapping("/{expenseId}/add/category/{categoryId}")
    public ResponseEntity<Expense> addCategoryToExpense(@PathVariable("expenseId") Long expenseId,
                                                        @PathVariable("categoryId") Long categoryId) throws Exception {
        return ResponseEntity.ok().body(expenseService.addCategoryToExpense(expenseId, categoryId));
    }

    @PostMapping("/filters")
    public ResponseEntity<List<Expense>> findExpenseWithFilters(@RequestBody JSONObject filters) {
        return ResponseEntity.ok().body(expenseService.findByFilters(filters));
    }
}
