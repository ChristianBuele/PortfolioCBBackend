package com.cb.portfolio.application.usecase;

import com.cb.portfolio.application.port.in.PackageProductPhotosInPort;
import com.cb.portfolio.application.port.out.PackageProductOutPort;
import com.cb.portfolio.application.port.out.PackageProductPhotosOutPort;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.PackageProductPhotos;
import com.cb.portfolio.domain.model.Photo;
import com.cb.portfolio.domain.model.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PackageProductPhotosUseCase implements PackageProductPhotosInPort {

    private final PackageProductPhotosOutPort packageProductPhotosOutPort;
    private final PackageProductOutPort packageProductOutPort;

    @Override
    public List<Product> findAllByPackageProductId(Long packageId) {
        List<Product> data= this.packageProductOutPort.findProductsByPackageId(packageId);

        return data.stream().map(product -> {
            List<PackageProductPhotos> productPhotos = this.packageProductPhotosOutPort.findPhotosByPackageAndProduct(packageId,product.getId());
            List<Photo> photos = productPhotos.stream().map(PackageProductPhotos::getPhoto).toList();
            String description="";
            if(!productPhotos.isEmpty()){
                description  = productPhotos.get(0).getDescription();
            }
            product.setDescription(description);
            product.setPhotos(photos);
            return product;
        }).toList();
    }
}