package com.example.backend.product.service;

import com.example.backend.category.service.CategoryService;
import com.example.backend.common.exception.BaseException;
import com.example.backend.common.exception.ErrorCode;
import com.example.backend.common.exception.NotFoundException;
import com.example.backend.product.dto.ProductInsertRequest;
import com.example.backend.product.dto.ProductResponse;
import com.example.backend.product.entity.Product;
import com.example.backend.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    @Override
    public List<ProductResponse> getProductList() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return new ProductResponse(product);
    }

    @Override
    public void insertProduct(ProductInsertRequest request) {
        categoryService.getCategory(request.getCategoryId());
        if (categoryService.isParentCategoryId(request.getCategoryId())) {
            throw new BaseException(ErrorCode.INVALID_PARAMETER, "categoryId : " + request.getCategoryId());
        }
        productRepository.save(new Product(request));
    }
}
