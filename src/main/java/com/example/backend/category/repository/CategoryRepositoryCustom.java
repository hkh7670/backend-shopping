package com.example.backend.category.repository;

import com.example.backend.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoryRepositoryCustom  {
    List<Category> getCategoryList();
}
