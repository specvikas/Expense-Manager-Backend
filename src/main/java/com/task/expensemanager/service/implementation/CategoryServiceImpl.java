package com.task.expensemanager.service.implementation;

import com.task.expensemanager.entity.Category;
import com.task.expensemanager.entity.User;
import com.task.expensemanager.repository.CategoryRepository;
import com.task.expensemanager.repository.UserRepository;
import com.task.expensemanager.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findByUser(String username) {

        User user = userRepository.findByUsername(username);
        return categoryRepository.findByUser_Id(user.getId());
    }
}
