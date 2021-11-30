package com.task.expensemanager.service.implementation;

import com.task.expensemanager.entity.Category;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public List<Category> findByFilters(JSONObject filters) {
        return null;
    }
}
