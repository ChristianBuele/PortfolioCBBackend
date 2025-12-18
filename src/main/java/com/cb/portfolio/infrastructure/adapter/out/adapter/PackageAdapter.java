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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PackageAdapter implements PackageOutPort {

    private final PackageRepository packageRepository;
    private final PackageMapper packageMapper;

    @Override
    public Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory) {


        Sort sort = Sort.unsorted();

        if (sortBy != null && sortDir != null) {
            Sort.Direction dir = Sort.Direction.fromString(sortDir);
                sort = Sort.by(dir, sortBy);
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        org.springframework.data.domain.Page<PackageEntity> packageEntities = packageRepository.findAllByFilters(idCategory,title,pageable);
        return Page.<Package>builder()
                .content(packageEntities.getContent().stream().map(packageMapper::toDomain).toList())
                .totalPages(packageEntities.getTotalPages())
                .pageNumber(page)
                .pageSize(size)
                .totalElements(packageEntities.getTotalElements())
                .build();
    }

    @Override
    public Optional<Package> findPackageById(Long id) {
        return this.packageRepository.findById(id).map(this.packageMapper::toDomain);
    }
}