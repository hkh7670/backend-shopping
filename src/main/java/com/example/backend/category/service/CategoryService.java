package com.example.backend.category.service;

import com.example.backend.category.dto.CategoryResponse;

public interface CategoryService {
    CategoryResponse getCategory(Long id);
    boolean isParentCategoryId(Long id);
}
