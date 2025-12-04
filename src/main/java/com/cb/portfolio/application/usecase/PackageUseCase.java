package com.cb.portfolio.application.usecase;

import com.cb.portfolio.application.port.in.PackageInPort;
import com.cb.portfolio.application.port.out.PackageOutPort;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PackageUseCase implements PackageInPort {

    private final PackageOutPort packageOutPort;

    @Override
    public Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory) {
        String nameFilter = ((title == null || title.isBlank()) ? "" : title).toLowerCase();
        return this.packageOutPort.findAllPackagesByFilters(page,size,sortBy,sortDir,nameFilter,idCategory);
    }
}
