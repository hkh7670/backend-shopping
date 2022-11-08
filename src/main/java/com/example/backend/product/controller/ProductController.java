package com.example.backend.product.controller;

import com.example.backend.product.dto.ProductInsertRequest;
import com.example.backend.product.dto.ProductResponse;
import com.example.backend.product.dto.ProductSelectRequest;
import com.example.backend.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<PageImpl<ProductResponse>> getProductList(ProductSelectRequest request, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(productService.getProductList(request, pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping()
    public ResponseEntity<?> insertProduct(@RequestBody ProductInsertRequest request) {
        productService.insertProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
