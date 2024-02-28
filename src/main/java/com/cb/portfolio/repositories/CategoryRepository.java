package com.cb.portfolio.repositories;

import com.cb.portfolio.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
