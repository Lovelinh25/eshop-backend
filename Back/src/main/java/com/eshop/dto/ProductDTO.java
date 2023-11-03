package com.eshop.dto;

import com.eshop.entity.ImageProduct;
import com.eshop.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private String name;
    private Double price;
    private  String description;
    private String tradeMark;
    private List<ImageProduct> imageProducts;
}
