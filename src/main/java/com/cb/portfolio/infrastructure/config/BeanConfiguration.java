package com.cb.portfolio.infrastructure.config;

import com.cb.portfolio.application.port.in.CategoryInPort;
import com.cb.portfolio.application.port.in.PackageInPort;
import com.cb.portfolio.application.port.out.CategoryOutPort;
import com.cb.portfolio.application.port.out.PackageOutPort;
import com.cb.portfolio.application.usecase.CategoryUseCase;
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
    public PackageInPort packageUseCase(PackageOutPort packageOutPort) {
        return new PackageUseCase(packageOutPort);
    }
}
