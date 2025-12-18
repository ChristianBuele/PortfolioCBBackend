package com.cb.portfolio.infrastructure.adapter.in.rest;

import com.cb.portfolio.application.port.in.PackageProductPhotosInPort;
import com.cb.portfolio.domain.model.PackageProductPhotos;
import com.cb.portfolio.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/package-product-photos")
@RequiredArgsConstructor
public class PackageProductPhotosController {

    private final PackageProductPhotosInPort packageProductPhotosInPort;

    @GetMapping
    public List<Product> findAllByPackageProductId(@RequestParam Long packageProductId) {
        return this.packageProductPhotosInPort.findAllByPackageProductId(packageProductId);
    }
}
