package com.task.expensemanager.repository;

import com.task.expensemanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    ArrayList<Expense> findByCreatedAtBetween(Date startDate, Date endDate);

    ArrayList<Expense> findByUser_Id(long id);

    ArrayList<Expense> findByCategory_Id(long categoryId);
}
