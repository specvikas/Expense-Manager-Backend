package com.task.expensemanager.service.implementation;

import com.task.expensemanager.entity.Category;
import com.task.expensemanager.entity.Expense;
import com.task.expensemanager.entity.User;
import com.task.expensemanager.repository.CategoryRepository;
import com.task.expensemanager.repository.ExpenseRepository;
import com.task.expensemanager.repository.UserRepository;
import com.task.expensemanager.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final UserRepository userRepository;

    private final ExpenseRepository expenseRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense addCategoryToExpense(Long expenseId, Long categoryId) throws Exception {

        Optional<Expense> optionalExpense = expenseRepository.findById(expenseId);

        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);


        if(optionalCategory.isPresent() && optionalExpense.isPresent()) {
            optionalExpense.get().setCategory(optionalCategory.get());
            return optionalExpense.get();
        }

        throw new Exception("Expense or Category data not found !!");
    }

    @Override
    public List<Expense> findByFilters(JSONObject filters) {

        ArrayList<Expense> filteredExpenses = new ArrayList<>(0);

        if(filters.has("startDate") && filters.has("endDate")) {
            Date startDate = new Date(filters.getString("startDate"));
            Date endDate = new Date(filters.getString("endDate"));

            filteredExpenses.addAll(expenseRepository.findByCreatedAtBetween(startDate, endDate));
        }

        if(filters.has("username")) {
            User user = userRepository.findByUsername(filters.getString("username"));
            filteredExpenses.addAll(expenseRepository.findByUser_Id(user.getId()));
        }

        if(filters.has("categoryId")) {
            filteredExpenses.addAll(expenseRepository.findByCategory_Id(filters.getLong("categoryId")));
        }

        return filteredExpenses;
    }
}
