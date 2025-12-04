package com.cb.portfolio.infrastructure.adapter.in.rest;

import com.cb.portfolio.application.port.in.CategoryInPort;
import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.domain.model.Page;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryInPort categoryInPort;
    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size) {
        return this.categoryInPort.getAllCategories(page,size);
    }
}
