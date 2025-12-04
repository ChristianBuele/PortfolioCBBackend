package com.cb.portfolio.infrastructure.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_packages_category_name",
                        columnNames = {"id_category", "name"}
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageEntity  extends AuditEntity{

    @Id
    @Basic(optional = false)
    @Column(name = "id_package")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category",nullable = false)
    private CategoryEntity category;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Column(precision = 19, scale = 2)
    private BigDecimal discount;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean recommended;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_photo", referencedColumnName = "id_photo",nullable = false)
    private PhotoEntity cover;
}
