package com.project.eshop.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.eshop.dtos.CategoryDTO;
import com.project.eshop.model.Category;

public interface ICategoryService {

    // create a new category
    Category createCategory(CategoryDTO categoryDTO);

    // get Page of categories
    Page<Category> getAllCategories(Pageable pageable);

    // get a category by id
    Category getCategory(Long id);

    // update a category
    Category updateCategory(Long id, CategoryDTO categoryDTO);

    // delete a category
    void deleteCategory(Long id);
}
