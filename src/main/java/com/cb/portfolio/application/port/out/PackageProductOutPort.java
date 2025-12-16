package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.PackageProduct;

import java.util.List;

public interface PackageProductOutPort {
    List<PackageProduct> findProductsByPackageIds(List<Long> packageIds);
}
