package com.cb.portfolio.infrastructure.adapter.out.persistence.mapper;

import com.cb.portfolio.domain.model.PackageProduct;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ProductMapper.class,
                PackageMapper.class
        }
)
public interface PackageProductMapper {

    @Mapping(source = "productEntity",target = "product")
    @Mapping(source = "packageEntity",target = "packageModel")
    PackageProduct toDomain(PackageProductEntity entity);

    List<PackageProduct> toDomainList(List<PackageProductEntity> entities);
}
