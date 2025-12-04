package com.cb.portfolio.application.usecase;

import com.cb.portfolio.application.port.in.CategoryInPort;
import com.cb.portfolio.application.port.out.CategoryOutPort;
import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.domain.model.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
public class CategoryUseCase implements CategoryInPort {
    private final CategoryOutPort categoryOutPort;

    @Override
    public Page<Category> getAllCategories(int page, int size) {
        return this.categoryOutPort.findAllCategories(page,size);
    }
}
