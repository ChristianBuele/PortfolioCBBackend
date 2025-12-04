package com.cb.portfolio.infrastructure.adapter.out.persistence.mapper;

import com.cb.portfolio.domain.model.Photo;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    Photo toDomain(PhotoEntity photoEntity);
}