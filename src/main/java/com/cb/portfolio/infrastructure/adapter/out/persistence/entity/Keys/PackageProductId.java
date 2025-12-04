package com.cb.portfolio.infrastructure.adapter.out.persistence.entity.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageProductId implements Serializable {

    @Column(name = "id_package")
    private Long packageId;

    @Column(name = "id_product")
    private Long productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageProductId that)) return false;
        return Objects.equals(packageId, that.packageId)
                && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId, productId);
    }
}