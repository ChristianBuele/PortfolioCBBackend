package com.cb.portfolio.services;

import com.cb.portfolio.entities.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();
}
