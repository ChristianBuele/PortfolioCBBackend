package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.PackageProductPhotos;
import com.cb.portfolio.domain.model.Photo;

import java.util.List;

public interface PackageProductPhotosOutPort {

    List<PackageProductPhotos> findPhotosByPackageAndProduct(Long idPackage, Long idProduct);
}
