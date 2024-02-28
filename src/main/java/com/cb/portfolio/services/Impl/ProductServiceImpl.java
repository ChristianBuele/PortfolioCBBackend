package com.cb.portfolio.services.Impl;

import com.cb.portfolio.entities.Product;
import com.cb.portfolio.repositories.ProductRepository;
import com.cb.portfolio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll(int offset, int limit) {
        Pageable pageable = Pageable.ofSize(limit).withPage(offset);
        return productRepository.findAll(pageable).getContent();
//        return productRepository.findAllWithImages();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public long count() {
        return productRepository.count();
    }


}
