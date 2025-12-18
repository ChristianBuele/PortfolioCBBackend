package com.cb.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Package {
    private Long id;

    private Category  category;

    private String name;

    private BigDecimal price;

    private BigDecimal discount;

    private boolean recommended;

    private Photo cover;

    private List<Product> products;

    private String description;
}
