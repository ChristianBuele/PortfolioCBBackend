package com.cb.portfolio.infrastructure.adapter.out.persistence.mapper;

import com.cb.portfolio.domain.model.PackageProductPhotos;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageProductPhotosEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
uses = {
        PhotoMapper.class,
        PackageMapper.class,
        ProductMapper.class
})
public interface PackageProductPhotosMapper {

    PackageProductPhotos toDomain(PackageProductPhotosEntity entity);

    List<PackageProductPhotos> toDomainList(List<PackageProductPhotosEntity> entities);
}
