package com.task.expensemanager.repository;

import com.task.expensemanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findByUser_Id(long userId);
}
