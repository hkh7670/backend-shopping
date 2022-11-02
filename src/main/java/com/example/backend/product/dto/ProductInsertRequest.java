package com.example.backend.product.dto;

import lombok.Getter;

@Getter
public class ProductInsertRequest {
    private Long categoryId;
    private String name;
    private Long price;
    private Long stockCnt;
}
