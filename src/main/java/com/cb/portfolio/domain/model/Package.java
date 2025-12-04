package com.cb.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
}
