package com.example.backend.product.service;

import com.example.backend.product.dto.ProductInsertRequest;
import com.example.backend.product.dto.ProductResponse;
import com.example.backend.product.dto.ProductSelectRequest;
import com.example.backend.product.entity.Product;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse getProduct(Long id);
    PageImpl<ProductResponse> getProductList(ProductSelectRequest request, Pageable pageable);
    void insertProduct(ProductInsertRequest request);
}
