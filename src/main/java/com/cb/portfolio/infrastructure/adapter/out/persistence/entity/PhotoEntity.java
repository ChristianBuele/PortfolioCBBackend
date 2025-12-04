package com.cb.portfolio.infrastructure.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhotoEntity  extends AuditEntity{

    @Id
    @Basic(optional = false)
    @Column(name = "id_photo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,columnDefinition = "text")
    private String url;

}