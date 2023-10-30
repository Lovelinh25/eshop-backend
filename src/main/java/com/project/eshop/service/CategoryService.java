package com.project.eshop.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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
        if (categoryDTO.getName() == null || categoryDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (categoryRepository.existsById(id)) {
            return categoryRepository.save(Category.builder().id(id).name(categoryDTO.getName()).build());
        } else {
            throw new EntityNotFoundException("This category ID does not exist: " + id);
        }
    }
    
    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ID " + id + " not exists");
        }
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
