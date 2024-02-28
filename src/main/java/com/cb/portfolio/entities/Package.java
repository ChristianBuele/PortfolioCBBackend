package com.cb.portfolio.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "packages")
@Data
public class Package {
    @Column(name = "id_package")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_category")
    private Category category;
}
