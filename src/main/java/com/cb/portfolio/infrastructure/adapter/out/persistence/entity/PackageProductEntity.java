package com.cb.portfolio.infrastructure.adapter.out.persistence.entity;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.Keys.PackageProductId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "package_products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageProductEntity extends AuditEntity {

    @EmbeddedId
    private PackageProductId id;

    @ManyToOne
    @JoinColumn(name = "id_package", referencedColumnName = "id_package", nullable = false)
    @MapsId("packageId")
    private PackageEntity packageEntity;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable= false)
    @MapsId("productId")
    private ProductEntity productEntity;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}