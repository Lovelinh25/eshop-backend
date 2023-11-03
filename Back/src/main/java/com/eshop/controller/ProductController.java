package com.eshop.controller;

import com.eshop.dto.ProductDTO;
import com.eshop.entity.Product;
import com.eshop.form.CreatingProductForm;
import com.eshop.form.UpdatingProductForm;
import com.eshop.service.IProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<ProductDTO> getAllProducts(Pageable pageable, @RequestParam(value = "search", required = false) String search, Product product){
        Page<Product> entityPages = service.getAllProducts(pageable, search, product);
        List<ProductDTO>  dtos = modelMapper.map(entityPages.getContent(),
                new TypeToken<List<ProductDTO>>(){}.getType());

        Page<ProductDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());
        return dtoPages;
    }

    @GetMapping(value = "/{id}")
    public ProductDTO getProductById(@PathVariable(name = "id") int id){
        Product entity = service.getProductById(id);
        ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
        return dto;
    }
    @PostMapping
    public void createProduct(@RequestBody @Valid CreatingProductForm form){
        service.createProduct(form);
    }
    @PutMapping(value = "/{id}")
    public void updateProduct(@PathVariable(name = "id") int id, @RequestBody UpdatingProductForm form){
        form.setId(id);
        service.updateProduct(form);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable(name = "id") int id){
        service.deleteProduct(id);
    }
}
