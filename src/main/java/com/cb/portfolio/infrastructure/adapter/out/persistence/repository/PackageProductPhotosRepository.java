package com.cb.portfolio.infrastructure.adapter.out.persistence.repository;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageProductPhotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PackageProductPhotosRepository extends JpaRepository<PackageProductPhotosEntity,Long> {


    @Query("""
            select p from PackageProductPhotosEntity p
            where p.pckage.id = :packageId
            and p.product.id = :idProduct
            """)
    List<PackageProductPhotosEntity> findAllByPackageProductId(Long packageId,Long idProduct);
}