package com.cb.portfolio.infrastructure.adapter.out.adapter;

import com.cb.portfolio.application.port.out.PackageProductPhotosOutPort;
import com.cb.portfolio.domain.model.PackageProductPhotos;
import com.cb.portfolio.infrastructure.adapter.out.persistence.mapper.PackageProductPhotosMapper;
import com.cb.portfolio.infrastructure.adapter.out.persistence.repository.PackageProductPhotosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageProductPhotosAdapter implements PackageProductPhotosOutPort {

    private final PackageProductPhotosRepository packageProductPhotosRepository;
    private final PackageProductPhotosMapper packageProductPhotosMapper;


    @Override
    public List<PackageProductPhotos> findAllByPackageProductId(Long packageProductId) {
        return this.packageProductPhotosMapper.toDomainList(this.packageProductPhotosRepository.findAllByPackageProductId(packageProductId));
    }
}
