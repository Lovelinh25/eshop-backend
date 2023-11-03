package com.eshop.service;

import com.eshop.entity.Product;
import com.eshop.form.CreatingProductForm;
import com.eshop.form.UpdatingProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Product getProductById(int id);

    Page<Product> getAllProducts(Pageable pageable, String search, Product product);

    void createProduct(CreatingProductForm form);

    void updateProduct(UpdatingProductForm form);

    void deleteProduct(int id);
}