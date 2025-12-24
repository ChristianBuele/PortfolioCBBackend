package com.cb.portfolio.infrastructure.adapter.out.persistence.repository;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageProductEntity;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageProductRepository extends JpaRepository<PackageProductEntity,Long> {

    @Query(value = """
            select pp from PackageProductEntity pp
                join fetch pp.productEntity
                where pp.packageEntity.id in :packageIds
            """)
    List<PackageProductEntity> findAllByPackageEntityIds(@Param("packageIds") List<Long> packageIds);

    @Query("""
            select pp.productEntity from PackageProductEntity pp
            where pp.packageEntity.id = :idPackage
            """)
    List<ProductEntity> findProductsByPackage(Long idPackage);

    @Query("""
            select distinct pp.productEntity from PackageProductEntity pp
            where pp.packageEntity.category.id = :idCategory
            """)
    List<ProductEntity> findProductsByCategory(Long idCategory);
}