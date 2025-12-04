package com.cb.portfolio.infrastructure.adapter.out.adapter;

import com.cb.portfolio.application.port.out.CategoryOutPort;
import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.domain.model.Page;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.CategoryEntity;
import com.cb.portfolio.infrastructure.adapter.out.persistence.mapper.CategoryMapper;
import com.cb.portfolio.infrastructure.adapter.out.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryAdapter implements CategoryOutPort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<Category> findAllCategories(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        org.springframework.data.domain.Page<CategoryEntity> categoryPage = categoryRepository.findAll(pageable);
        var categories = categoryPage.getContent().stream()
                .map(this.categoryMapper::toDomain)
                .toList();
        return new Page<Category>(
                categories,
                categoryPage.getNumber(),
                categoryPage.getSize(),
                categoryPage.getTotalElements(),
                categoryPage.getTotalPages()
        );
    }
}
