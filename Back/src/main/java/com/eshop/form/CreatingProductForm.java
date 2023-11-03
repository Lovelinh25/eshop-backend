package com.eshop.form;

import com.eshop.entity.ImageProduct;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CreatingProductForm {

    @NotNull
    private String name;

    @Positive(message = "Price must be greater than zero")
    private Double price;

    private String description;

    private Date created_date;

    @Positive(message = "Price must be greater than zero")
    private Integer quantity;

    private String tradeMark;

//    private List<ImageProduct> imageProducts;
}
