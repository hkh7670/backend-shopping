package com.example.backend.category.service;

import com.example.backend.category.dto.CategoryResponse;
import com.example.backend.category.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse getCategory(Long id);
    List<Category> getCategoryList();
    boolean isParentCategoryId(Long id);
}
