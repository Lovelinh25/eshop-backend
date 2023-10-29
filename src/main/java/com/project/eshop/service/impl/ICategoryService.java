package com.project.eshop.service.impl;

import java.util.List;

import com.project.eshop.dtos.CategoryDTO;
import com.project.eshop.model.Category;

public interface ICategoryService {

    // create a new category
    Category createCategory(CategoryDTO categoryDTO);

    // get all categories
    List<Category> getAllCategories();

    // get a category by id
    Category getCategory(Long id);

    // update a category
    Category updateCategory(Long id, CategoryDTO categoryDTO);

    // delete a category
    void deleteCategory(Long id);
}
