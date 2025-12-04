package com.cb.portfolio.application.port.in;

import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.domain.model.Page;

public interface CategoryInPort {
    Page<Category> getAllCategories(int page, int size);
}
