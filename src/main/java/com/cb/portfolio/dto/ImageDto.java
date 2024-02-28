package com.cb.portfolio.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ImageDto {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Alt is required")
    private String alt;
    @NotBlank(message = "Url is required")
    private String url;
    @NotNull(message = "id_product is required")
    private Long id_product;
}
