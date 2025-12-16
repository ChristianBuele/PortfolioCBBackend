package com.cb.portfolio.infrastructure.adapter.out.persistence.repository;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
