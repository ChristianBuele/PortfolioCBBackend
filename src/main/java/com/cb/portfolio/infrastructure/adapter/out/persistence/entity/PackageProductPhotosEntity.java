package com.cb.portfolio.infrastructure.adapter.out.persistence.entity;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.Keys.PackageProductPhotoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "package_products_photos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageProductPhotosEntity {

    @EmbeddedId
    private PackageProductPhotoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("packageId")
    @JoinColumn(name = "id_package", nullable = false)
    private PackageEntity pckage;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "id_product", nullable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("photoId")
    @JoinColumn(name = "id_photo", nullable = false)
    private PhotoEntity photo;

    @Column(name = "description", length = 256)
    private String description;
}
