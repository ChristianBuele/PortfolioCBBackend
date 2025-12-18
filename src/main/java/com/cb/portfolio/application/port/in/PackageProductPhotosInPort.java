package com.cb.portfolio.application.port.in;

import com.cb.portfolio.domain.model.PackageProductPhotos;
import com.cb.portfolio.domain.model.Product;

import java.util.List;

public interface PackageProductPhotosInPort {
    List<Product> findAllByPackageProductId(Long packageProductId);
}
