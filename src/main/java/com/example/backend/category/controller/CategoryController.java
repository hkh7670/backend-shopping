package com.example.backend.category.controller;

import com.example.backend.category.dto.CategoryResponse;
import com.example.backend.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
}
