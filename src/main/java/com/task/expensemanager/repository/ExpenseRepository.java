package com.task.expensemanager.repository;

import com.task.expensemanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    
}
