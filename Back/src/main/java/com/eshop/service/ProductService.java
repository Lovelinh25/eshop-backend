package com.eshop.service;

import com.eshop.entity.Product;
import com.eshop.form.CreatingProductForm;
import com.eshop.form.UpdatingProductForm;
import com.eshop.repository.IProductRepository;
import com.eshop.specification.ProductSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.Date;

=======
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<Product> getAllProducts(Pageable pageable, String search, Product product){
        Specification<Product> where = ProductSpecification.buildWhere(search, product);
        return repository.findAll(where, pageable);
    }

    public Product getProductById(int id){
        return repository.getById(id);
    }

    public void createProduct(CreatingProductForm form){
<<<<<<< HEAD
        form.setCreated_date(new Date(System.currentTimeMillis()));
=======
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
        Product entity = modelMapper.map(form, Product.class);
        Product product = repository.save(entity);
    }

    public void updateProduct(UpdatingProductForm form){
<<<<<<< HEAD
        form.setCreated_date(new Date(System.currentTimeMillis()));
=======
>>>>>>> 6b56a28734ec1f133efc451c6bfcc5aafd490a22
        Product product = modelMapper.map(form, Product.class);
        repository.save(product);
    }
    public void deleteProduct(int id){
        repository.deleteById(id);
    }


}
