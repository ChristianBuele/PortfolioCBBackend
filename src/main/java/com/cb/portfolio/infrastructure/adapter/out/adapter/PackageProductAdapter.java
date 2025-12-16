package com.cb.portfolio.infrastructure.adapter.out.adapter;

import com.cb.portfolio.application.port.out.PackageProductOutPort;
import com.cb.portfolio.domain.model.PackageProduct;
import com.cb.portfolio.infrastructure.adapter.out.persistence.mapper.PackageProductMapper;
import com.cb.portfolio.infrastructure.adapter.out.persistence.repository.PackageProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PackageProductAdapter implements PackageProductOutPort {

    private final PackageProductRepository packageProductRepository;
    private final PackageProductMapper packageProductMapper;

    @Override
    public List<PackageProduct> findProductsByPackageIds(List<Long> packageIds){
        if (packageIds == null || packageIds.isEmpty()) {
            return Collections.emptyList();
        }
       return this.packageProductMapper.toDomainList(this.packageProductRepository.findAllByPackageEntityIds(packageIds));
    }
}
