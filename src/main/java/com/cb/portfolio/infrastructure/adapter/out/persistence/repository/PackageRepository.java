package com.cb.portfolio.infrastructure.adapter.out.persistence.repository;

import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PackageRepository extends JpaRepository<PackageEntity,Long> {

    @Query("""
        SELECT p FROM PackageEntity p
        WHERE (:idCategory IS NULL OR p.category.id = :idCategory)
          AND (:name IS NULL OR :name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
        """)
    Page<PackageEntity> findAllByFilters(
            @Param("idCategory") Long idCategory,
            @Param("name") String name,
            Pageable pageable);
}
