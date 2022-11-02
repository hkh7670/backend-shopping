package com.example.backend.category.entity;

import com.example.backend.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "CATEGORY")
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long parentId;

    @Column
    private String name;

//    @OneToMany(mappedBy = "category")
//    private List<Product> productList = new ArrayList<>();
}
