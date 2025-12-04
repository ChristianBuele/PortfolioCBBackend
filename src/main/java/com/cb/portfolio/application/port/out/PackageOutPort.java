package com.cb.portfolio.application.port.out;

import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;

public interface PackageOutPort {
   Page<Package> findAllPackagesByFilters(int page, int size, String sortBy, String sortDir, String title, Long idCategory);
}
