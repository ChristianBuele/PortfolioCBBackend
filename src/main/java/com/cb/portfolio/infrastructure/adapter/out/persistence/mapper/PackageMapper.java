package com.cb.portfolio.infrastructure.adapter.out.persistence.mapper;

import com.cb.portfolio.domain.model.Category;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.CategoryEntity;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        uses = {
                PhotoMapper.class,
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PackageMapper {

    @Mapping(target = "category", source = "category")
    Package toDomain(PackageEntity packageEntity);

    default Category toCategory(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }
        Category category = new Category();
        category.setId(entity.getId());
        return category;
    }
}
