package com.example.backend.product.repository;

import com.example.backend.category.entity.QCategory;
import com.example.backend.product.dto.ProductResponse;
import com.example.backend.product.dto.ProductSelectRequest;
import com.example.backend.product.entity.QProduct;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    QProduct product = QProduct.product;
    QCategory category = QCategory.category;

    @Override
    public PageImpl<ProductResponse> getProductList(ProductSelectRequest request, Pageable pageable) {
        Long total = queryFactory.select(product.count())
                .from(product)
                .where(likeProductName(request.getProductName()), dateBetween(request.getStartDate(), request.getEndDate()))
                .innerJoin(product.category)
                .fetchOne();
        if (total == null) {
            total = 0L;
        }
        List<ProductResponse> content = queryFactory.select(Projections.constructor(ProductResponse.class, product))
                .from(product)
                .where(likeProductName(request.getProductName()), dateBetween(request.getStartDate(), request.getEndDate()))
                .innerJoin(product.category)
                .fetchJoin()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(content, pageable, total);
    }

    public BooleanExpression likeProductName(String productName) {
        if (ObjectUtils.isEmpty(productName)) {
            return null;
        }
        return product.name.like("%" + productName + "%");
    }

    public BooleanExpression dateBetween(String startDate, String endDate) {
        if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty(endDate)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return product.regDate.between(LocalDate.parse(startDate, formatter).atStartOfDay(), LocalDate.parse(endDate, formatter).plusDays(1L).atStartOfDay());
    }
}
