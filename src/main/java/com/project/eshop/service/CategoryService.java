package com.project.eshop.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.project.eshop.dto.CategoryDTO;
import com.project.eshop.entity.Category;
import com.project.eshop.repository.CategoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        String name = categoryDTO.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name category cannot be empty");
        }
        if (!name.matches("[\\p{L}0-9 ]*")) {
            throw new IllegalArgumentException("Name category can only contain letters and numbers");
        }
        if (name.length() < 1 || name.length() > 20) {
            throw new IllegalArgumentException("Name category must be between 1 and 20 characters");
        }
        Optional<Category> existingCategory = Optional.ofNullable(findCategory(name));
        if (existingCategory.isPresent()) {
            throw new IllegalArgumentException("Category '" + name + "' already exists");
        }
        Category newCategory = Category
                .builder()
                .name(name)
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        String name = categoryDTO.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name category cannot be empty");
        }
        if (!name.matches("[\\p{L}0-9 ]*")) {
            throw new IllegalArgumentException("Name category can only contain letters and numbers");
        }
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            return categoryRepository.save(Category.builder().id(id).name(name).build());
        } else {
            throw new EntityNotFoundException("This category ID does not exist: " + id);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
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