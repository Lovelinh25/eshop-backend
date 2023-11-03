package com.eshop.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name ="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_date;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private  String description;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
    @Column(name = "tradeMark")
    private String tradeMark;


//    @JsonIgnore
//    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
//    private List<ImageProduct> imageProducts;

}
