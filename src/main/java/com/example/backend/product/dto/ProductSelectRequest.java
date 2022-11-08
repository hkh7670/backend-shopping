package com.example.backend.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductSelectRequest {
    private String productName;
    private String startDate;
    private String endDate;
}
