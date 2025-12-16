package com.cb.portfolio.application.usecase;

import com.cb.portfolio.application.port.in.PackageInPort;
import com.cb.portfolio.application.port.out.PackageOutPort;
import com.cb.portfolio.application.port.out.PackageProductOutPort;
import com.cb.portfolio.application.port.out.ProductOutPort;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.PackageProduct;
import com.cb.portfolio.domain.model.Page;
import com.cb.portfolio.domain.model.Product;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PackageUseCase implements PackageInPort {

    private final PackageOutPort packageOutPort;
    private final ProductOutPort productOutPort;
    private final PackageProductOutPort packageProductOutPort;

    @Override
    public Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory) {
        String nameFilter = ((title == null || title.isBlank()) ? "" : title).toLowerCase();
        Page<Package> data = this.packageOutPort.findAllPackagesByFilters(page, size, sortBy, sortDir, nameFilter, idCategory);

        // Obtener IDs de los paquetes en la página actual
        List<Long> packageIds = data.getContent().stream()
                .map(Package::getId)
                .toList();

        Map<Long,List<Product>> productsByPackage = this.packageProductOutPort.findProductsByPackageIds(packageIds).stream().map(
                        pkg->{
                            pkg.getProduct().setPrice(pkg.getPrice());
                            return pkg;
                        }
                ).collect(
                        Collectors.groupingBy(
                                pkg -> pkg.getPackageModel().getId(),
                                Collectors.mapping(PackageProduct::getProduct, Collectors.toList())
                        )
        );

        // Cargar todos los productos UNA sola vez
        List<Product> allProducts = this.productOutPort.findAllProducts();

        return Page.<Package>builder()
                .content(
                        data.getContent().stream().map(
                                pkg -> {
                                    List<Product> productsInPackage = productsByPackage.getOrDefault(pkg.getId(), Collections.emptyList());
                                    pkg.setProducts(includedAndNotIncludedProducts(allProducts, productsInPackage));
                                    return pkg;
                                }
                        ).toList()
                )
                .totalElements(data.getTotalElements())
                .totalPages(data.getTotalPages())
                .pageNumber(page)
                .pageSize(size)
                .build();
    }

    private List<Product> includedAndNotIncludedProducts(List<Product> allProducts, List<Product> productsByPackage){

        Set<Long> includedIds = productsByPackage.stream()
                .map(Product::getId)
                .collect(Collectors.toSet());

        return allProducts.stream()
                .map(product -> {
                    Product copy = product.copy(); // o new Product(product)
                    copy.setInPackage(includedIds.contains(product.getId()));
                    return copy;
                })
                .toList();
    }
}
