package com.eshop.form;

import com.eshop.entity.ImageProduct;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UpdatingProductForm {

    private int id;
    @NotNull
    private String name;

    @NotBlank(message = "Not blank")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    private  String description;

    @NotBlank
    private String tradeMark;

    private Date created_date;
    @Positive(message = "Price must be greater than zero")
    private Integer quantity;
    private List<ImageProduct> imageProducts;
}
