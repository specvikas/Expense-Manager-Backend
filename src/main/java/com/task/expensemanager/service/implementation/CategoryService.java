package com.task.expensemanager.service.implementation;

import com.task.expensemanager.entity.Category;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Category save(Category category);

    List<Category> findByFilters(JSONObject filters);
}
