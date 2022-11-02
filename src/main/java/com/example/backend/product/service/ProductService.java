package com.example.backend.product.service;

import com.example.backend.product.dto.ProductInsertRequest;
import com.example.backend.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProduct(Long id);
    List<ProductResponse> getProductList();
    void insertProduct(ProductInsertRequest request);
}
