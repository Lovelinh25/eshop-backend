package com.eshop.dto;

import com.eshop.entity.ImageProduct;
<<<<<<< HEAD
import com.eshop.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {
=======

import java.util.List;

public class ProductDTO {
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22

    private String name;
    private Double price;
    private  String description;
    private String tradeMark;
    private List<ImageProduct> imageProducts;
}
