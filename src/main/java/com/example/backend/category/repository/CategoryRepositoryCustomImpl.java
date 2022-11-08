package com.example.backend.category.repository;

import com.example.backend.category.entity.Category;
import com.example.backend.category.entity.QCategory;
import com.example.backend.product.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final QProduct product = QProduct.product;
    private final QCategory category = QCategory.category;

    @Override
    public List<Category> getCategoryList() {
        return queryFactory.selectFrom(category)
                .innerJoin(category.productList)
                .fetchJoin()
                .fetch();
    }
}
