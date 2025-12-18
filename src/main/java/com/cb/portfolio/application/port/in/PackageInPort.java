package com.cb.portfolio.application.port.in;

import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;


public interface PackageInPort {
    Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory);
    Package findPackageById(Long id);
}
