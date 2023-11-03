package com.eshop.form;

import com.eshop.entity.ImageProduct;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
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

<<<<<<< HEAD
    private Date created_date;
    @Positive(message = "Price must be greater than zero")
    private Integer quantity;
=======
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
    private List<ImageProduct> imageProducts;
}
