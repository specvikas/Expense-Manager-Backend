package com.task.expensemanager.service.implementation;

import com.task.expensemanager.entity.Expense;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public Expense save(Expense expense) {
        return null;
    }

    @Override
    public Expense addCategoryToExpense(Long expenseId, Long categoryId) {
        return null;
    }

    @Override
    public List<Expense> findByFilters(JSONObject filters) {
        return null;
    }
}
