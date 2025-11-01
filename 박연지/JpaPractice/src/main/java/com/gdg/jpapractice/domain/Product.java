package com.gdg.jpapractice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // 상품 ID (PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;      // 소속 브랜드 (FK)

    private String name;  // 상품 이름
    private int price;           // 상품 가격

    @Builder
    public Product(Brand brand, String name, int price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public void update(Brand brand, String name, int price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }
}

