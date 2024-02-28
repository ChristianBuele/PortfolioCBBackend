package com.cb.portfolio.services.Impl;

import com.cb.portfolio.entities.Category;
import com.cb.portfolio.repositories.CategoryRepository;
import com.cb.portfolio.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
