package com.cb.portfolio.infrastructure.adapter.out.persistence.repository;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
