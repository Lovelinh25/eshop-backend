package com.eshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ImageProduct")
@Data
public class ImageProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String link;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
