package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.PackageProductPhotos;

import java.util.List;

public interface PackageProductPhotosOutPort {

    List<PackageProductPhotos> findAllByPackageProductId(Long packageProductId);
}
