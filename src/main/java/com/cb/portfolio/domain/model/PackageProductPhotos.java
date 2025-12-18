package com.cb.portfolio.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageProductPhotos {
    private Package pckage;

    private Product product;

    private Photo photo;

    private String description;
}
