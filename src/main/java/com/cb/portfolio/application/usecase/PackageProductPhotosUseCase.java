package com.cb.portfolio.application.usecase;

import com.cb.portfolio.application.port.in.PackageProductPhotosInPort;
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

    @Override
    public List<Product> findAllByPackageProductId(Long packageProductId) {
        List<PackageProductPhotos> data= this.packageProductPhotosOutPort.findAllByPackageProductId(packageProductId);
        Map<String,List<PackageProductPhotos>> groupedByProduct = data.stream()
                .collect(Collectors.groupingBy(ppp -> ppp.getProduct().getName()));

        return groupedByProduct.values().stream()
                .map(group -> {
                    // Tomar el primer elemento para obtener datos base del producto
                    PackageProductPhotos first = group.get(0);
                    Product product = first.getProduct().copy();

                    // Agregar la descripción del package
                    product.setDescription(first.getDescription());

                    // Recopilar todas las fotos del grupo
                    List<Photo> photos = group.stream()
                            .map(PackageProductPhotos::getPhoto)
                            .filter(Objects::nonNull) // Filtrar nulls por seguridad
                            .collect(Collectors.toList());

                    product.setPhotos(photos);

                    return product;
                })
                .collect(Collectors.toList());
    }
}