package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.PackageProduct;
import com.cb.portfolio.domain.model.Product;

import java.util.List;

public interface PackageProductOutPort {
    List<PackageProduct> findProductsByPackageIds(List<Long> packageIds);
    List<Product> findProductsByPackageId(Long idPackage);
}
