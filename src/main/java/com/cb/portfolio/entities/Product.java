package com.cb.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product implements Serializable {
    @Column(name = "id_product")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name = "id_category",nullable = false)
    @JsonManagedReference
    private Category category;

    public Product() {
        this.images=new HashSet<>();
    }

    public Product(String name, String description, Double price, Category category) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
