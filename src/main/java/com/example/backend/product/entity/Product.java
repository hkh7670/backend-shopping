package com.example.backend.product.entity;

import com.example.backend.category.entity.Category;
import com.example.backend.common.entity.BaseTimeEntity;
import com.example.backend.product.dto.ProductInsertRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "PRODUCT")
@NoArgsConstructor
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column
    private String name;

    @Column
    private Long price;

    @Column
    private Long stockCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", insertable = false, updatable = false)
    private Category category;

    @Builder
    public Product(ProductInsertRequest request) {
        this.categoryId = request.getCategoryId();
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockCnt = request.getStockCnt();
    }
}
