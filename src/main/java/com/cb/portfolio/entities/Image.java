package com.cb.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image implements Serializable {
    @Column(name = "id_image")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String alt;
    private String url;

    @ManyToOne()
    @JoinColumn(name = "id_product",nullable = false)
    @JsonBackReference
    private Product product;


}
