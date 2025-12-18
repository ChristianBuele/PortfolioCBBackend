package com.cb.portfolio.infrastructure.adapter.in.rest;

import com.cb.portfolio.application.port.in.PackageInPort;
import com.cb.portfolio.domain.model.Package;
import com.cb.portfolio.domain.model.Page;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
public class PackageController {

    private final PackageInPort packageInputPort;

    @GetMapping
    public Page<Package> getPackages(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false,defaultValue = "name") String sortBy,
            @RequestParam(required = false,defaultValue = "asc") String sortDirection,
            @RequestParam(required = false) String search
            ) {
        return this.packageInputPort.findAllPackagesByFilters(
               page,
                size,
                sortBy,
                sortDirection,
                search,
                categoryId
        );
    }

    @GetMapping("/{id}")
    public Package getPackageById(@PathVariable Long id) {
        return this.packageInputPort.findPackageById(id);
    }
}
