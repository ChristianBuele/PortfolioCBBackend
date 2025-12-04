package com.cb.portfolio.infrastructure.adapter.out.persistence.entity.Keys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PackageProductPhotoId implements Serializable {

    @Column(name = "id_package")
    private Long packageId;

    @Column(name = "id_product")
    private Long productId;

    @Column(name = "id_photo")
    private Long photoId;

    public PackageProductPhotoId() {}

    public PackageProductPhotoId(Long packageId, Long productId, Long photoId) {
        this.packageId = packageId;
        this.productId = productId;
        this.photoId = photoId;
    }

    // getters, setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageProductPhotoId that)) return false;
        return Objects.equals(packageId, that.packageId)
                && Objects.equals(productId, that.productId)
                && Objects.equals(photoId, that.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId, productId, photoId);
    }
}