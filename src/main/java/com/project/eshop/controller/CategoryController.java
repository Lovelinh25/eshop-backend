package com.project.eshop.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.eshop.dtos.CategoryDTO;
import com.project.eshop.model.Category;
import com.project.eshop.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.version}/categories")
// @RequestMapping("/api/v1/categories")
@Validated
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    // CreateCategory
    @PostMapping
    public ResponseEntity<?> createCategory(
            @Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        Category existingCategory = categoryService.findCategory(categoryDTO.getName());
        if (existingCategory != null) {
            return ResponseEntity.badRequest().body("Category '" + categoryDTO.getName() + "' already exists");
        }
        if (categoryDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Category not empty");
        }
        categoryService.createCategory(categoryDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Create category '" + categoryDTO.getName() + "' successfully");
    }

    // GetAllCategories
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        Page<Category> categories = categoryService.getAllCategories(pageable);
        return ResponseEntity.ok(categories.getContent());
    }

    // GetCategoryById
    @GetMapping("/{id}")
    public Category getCategoryById() {
        return new Category();
    }

    // UpdateCategory
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Update category with id: " + id + " successfully");
    }

    // DeleteCategory
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete category with id: " + id + " successfully");
    }

}
