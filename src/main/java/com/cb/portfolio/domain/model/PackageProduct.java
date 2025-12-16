package com.cb.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PackageProduct {

    private Product product;
    private Package packageModel;
    private BigDecimal price;

}
