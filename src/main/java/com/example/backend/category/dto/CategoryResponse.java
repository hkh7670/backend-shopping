package com.example.backend.category.dto;

import com.example.backend.common.dto.BaseTimeResponse;
import com.example.backend.category.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse extends BaseTimeResponse {
    private Long id;
    private Long parentId;
    private String name;

    public CategoryResponse(Category category) {
        super(category.getRegDate(), category.getUptDate());
        this.id = category.getId();
        this.parentId = category.getParentId();
        this.name = category.getName();
    }

//    public CategoryResponse(Product product) {
//        super(product.getCategory().getRegDate(), product.getCategory().getUptDate());
//        Category category = product.getCategory();
//        this.id = category.getId();
//        this.parentId = category.getParentId();
//        this.name = category.getName();
//    }
}
