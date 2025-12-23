package com.cb.portfolio.infrastructure.config;

import com.cb.portfolio.application.port.in.CategoryInPort;
import com.cb.portfolio.application.port.in.PackageInPort;
import com.cb.portfolio.application.port.in.PackageProductPhotosInPort;
import com.cb.portfolio.application.port.out.*;
import com.cb.portfolio.application.usecase.CategoryUseCase;
import com.cb.portfolio.application.usecase.PackageProductPhotosUseCase;
import com.cb.portfolio.application.usecase.PackageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CategoryInPort categoryUseCase(CategoryOutPort categoryOutPort) {
        return new CategoryUseCase(categoryOutPort);
    }

    @Bean
    public PackageInPort packageUseCase(
            PackageOutPort packageOutPort,
            ProductOutPort productOutPort,
            PackageProductOutPort packageProductOutPort
    ) {

        return new PackageUseCase(packageOutPort,productOutPort,packageProductOutPort);
    }

    @Bean
    public PackageProductPhotosInPort packageProductPhotosUseCase(PackageProductPhotosOutPort packageProductPhotosOutPort,PackageProductOutPort packageProductOutPort) {
        return new PackageProductPhotosUseCase(packageProductPhotosOutPort,packageProductOutPort);
    }
}
