package com.cb.portfolio.infrastructure.adapter.out.persistence.mapper;


import com.cb.portfolio.domain.model.Product;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductEntity productEntity);

    List<Product> toDomain(List<ProductEntity> productEntities);

}
