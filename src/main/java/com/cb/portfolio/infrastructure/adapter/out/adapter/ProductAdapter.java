package com.cb.portfolio.infrastructure.adapter.out.adapter;

import com.cb.portfolio.application.port.out.ProductOutPort;
import com.cb.portfolio.domain.model.Product;
import com.cb.portfolio.infrastructure.adapter.out.persistence.mapper.ProductMapper;
import com.cb.portfolio.infrastructure.adapter.out.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductOutPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findAllProducts() {
        return this.productMapper.toDomain(this.productRepository.findAll());
    }
}
