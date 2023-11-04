package com.project.eshop.service;

import com.project.eshop.dto.CategoryDTO;
import com.project.eshop.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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