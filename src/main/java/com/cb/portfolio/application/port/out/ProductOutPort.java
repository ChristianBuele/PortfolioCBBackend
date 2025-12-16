package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.Product;

import java.util.List;

public interface ProductOutPort {

    List<Product> findAllProducts();
}
