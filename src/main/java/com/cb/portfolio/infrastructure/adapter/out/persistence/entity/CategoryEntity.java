package com.cb.portfolio.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_categories_code", columnNames = "code"),
                @UniqueConstraint(name = "uk_categories_name", columnNames = "name")
        }
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends AuditEntity{

    @Id
    @Basic(optional = false)
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 50)
    private String code;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_cover", referencedColumnName = "id_photo",nullable = false)
    private PhotoEntity photo;
}