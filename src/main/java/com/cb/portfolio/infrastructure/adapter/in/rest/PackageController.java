package com.cb.portfolio.infrastructure.adapter.in.rest;

import com.cb.portfolio.application.port.in.PackageInPort;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
public class PackageController {

    private final PackageInPort packageInputPort;

    @GetMapping
    public Page<Package> getPackages(
            @RequestParam(required = false) Long idCategory,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection,
            @RequestParam(required = false) String search
            ) {
        return this.packageInputPort.findAllPackagesByFilters(
               page,
                size,
                sortBy,
                sortDirection,
                search,
                idCategory
        );
    }
}
