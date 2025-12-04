package com.cb.portfolio.infrastructure.adapter.out.persistence.mapper;

import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {PhotoMapper.class}
)
public interface CategoryMapper {
    Category toDomain(CategoryEntity categoryEntity);
}