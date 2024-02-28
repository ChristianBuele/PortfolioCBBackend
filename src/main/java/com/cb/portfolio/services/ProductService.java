package com.cb.portfolio.services;

import com.cb.portfolio.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll(int offset, int limit);
    Optional<Product> findById(Long id);
    Product save(Product product);

    long count();

}
