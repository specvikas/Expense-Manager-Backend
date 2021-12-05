package com.task.expensemanager.service;

import com.task.expensemanager.entity.Expense;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.util.List;

public interface ExpenseService {

    Expense save(Expense expense);

    Expense addCategoryToExpense(Long expenseId, Long categoryId) throws Exception;

    List<Expense> findByFilters(JSONObject filters);
}
