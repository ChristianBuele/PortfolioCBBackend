package com.cb.portfolio.application.port.in;

import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;

import java.util.List;

public interface PackageInPort {
    Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory);
}
