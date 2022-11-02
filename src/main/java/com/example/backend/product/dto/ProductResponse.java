package com.example.backend.product.dto;

import com.example.backend.common.dto.BaseTimeResponse;
import com.example.backend.category.dto.CategoryResponse;
import com.example.backend.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse extends BaseTimeResponse {
    private Long id;
    private Long categoryId;
    private String name;
    private Long price;
    private Long stockCnt;
    private CategoryResponse category;

    public ProductResponse(Product product) {
        super(product.getRegDate(), product.getUptDate());
        this.id = product.getId();
        this.categoryId = product.getCategoryId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stockCnt = product.getStockCnt();
        if (product.getCategory() != null) {
            this.category = new CategoryResponse(product.getCategory());
        }
    }
}
