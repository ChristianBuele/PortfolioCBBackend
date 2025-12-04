package com.cb.portfolio.infrastructure.adapter.out.adapter;

import com.cb.portfolio.application.port.out.PackageOutPort;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;
import com.cb.portfolio.infrastructure.adapter.out.persistence.entity.PackageEntity;
import com.cb.portfolio.infrastructure.adapter.out.persistence.mapper.PackageMapper;
import com.cb.portfolio.infrastructure.adapter.out.persistence.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PackageAdapter implements PackageOutPort {

    private final PackageRepository packageRepository;
    private final PackageMapper packageMapper;

    @Override
    public Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory) {
        Pageable pageable = PageRequest.of(page, size);;
        org.springframework.data.domain.Page<PackageEntity> packageEntities = packageRepository.findAllByFilters(idCategory,title,sortBy,sortDir,pageable);
        return Page.<Package>builder()
                .content(packageEntities.getContent().stream().map(packageMapper::toDomain).toList())
                .totalPages(packageEntities.getTotalPages())
                .pageNumber(page)
                .pageSize(size)
                .totalElements(packageEntities.getTotalElements())
                .build();
    }
}