package com.eshop.form;

import com.eshop.entity.ImageProduct;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
import java.util.List;

@Data
@NoArgsConstructor
public class CreatingProductForm {

    @NotNull
    private String name;

<<<<<<< HEAD
    @Positive(message = "Price must be greater than zero")
    private Double price;

    private String description;

    private Date created_date;

    @Positive(message = "Price must be greater than zero")
    private Integer quantity;

    private String tradeMark;

//    private List<ImageProduct> imageProducts;
=======
    @NotBlank(message = "Not blank")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    private  String description;

    @NotBlank
    private String tradeMark;

    private List<ImageProduct> imageProducts;
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
}
