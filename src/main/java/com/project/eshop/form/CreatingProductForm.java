package com.project.eshop.form;

import com.project.eshop.entity.ImageProduct;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@NoArgsConstructor
public class CreatingProductForm {

    @NotNull
    private String name;

    @NotBlank(message = "Not blank")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    private  String description;

    @NotBlank
    private String tradeMark;

    private List<ImageProduct> imageProducts;
}

