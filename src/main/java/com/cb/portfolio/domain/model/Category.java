package com.cb.portfolio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;

    private String code;

    private String name;

    private String description;

    private Photo photo;

}