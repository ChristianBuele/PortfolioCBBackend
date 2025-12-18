package com.cb.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private boolean inPackage;
    private String description;
    private BigDecimal price= BigDecimal.ZERO;
    private List<Photo> photos;

    public Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.inPackage = false; // Resetear este campo
    }

    public Product copy() {
        return new Product(this);
    }
}
