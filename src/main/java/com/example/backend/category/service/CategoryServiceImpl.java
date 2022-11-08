package com.example.backend.category.service;

import com.example.backend.category.dto.CategoryResponse;
import com.example.backend.category.entity.Category;
import com.example.backend.common.exception.NotFoundException;
import com.example.backend.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.getCategoryList();
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return new CategoryResponse(category);
    }

    @Override
    public boolean isParentCategoryId(Long id) {
        return categoryRepository.existsByParentId(id);
    }
}
