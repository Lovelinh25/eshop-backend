package com.project.eshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.eshop.dtos.CategoryDTO;
import com.project.eshop.model.Category;
import com.project.eshop.repositories.CategoryRepository;
import com.project.eshop.service.impl.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(newCategory);
    }


    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category updatedCategory = Category
                .builder()
                .id(id)
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category findCategory(String name) {
        List<Category> categories = categoryRepository.findByName(name);
        return categories.isEmpty() ? null : categories.get(0);
    }

}
