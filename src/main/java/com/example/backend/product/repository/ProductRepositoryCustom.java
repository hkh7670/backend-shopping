package com.example.backend.product.repository;

import com.example.backend.product.dto.ProductResponse;
import com.example.backend.product.dto.ProductSelectRequest;
import com.example.backend.product.entity.Product;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepositoryCustom {
    PageImpl<ProductResponse> getProductList(ProductSelectRequest request, Pageable pageable);
}
