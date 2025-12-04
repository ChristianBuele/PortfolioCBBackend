package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.domain.model.Page;

public interface CategoryOutPort {
    Page<Category> findAllCategories(int page, int size);
}
