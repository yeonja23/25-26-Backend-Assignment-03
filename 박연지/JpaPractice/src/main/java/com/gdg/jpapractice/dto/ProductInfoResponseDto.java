package com.gdg.jpapractice.dto;

import com.gdg.jpapractice.domain.Product;
import lombok.Builder;

@Builder
public record ProductInfoResponseDto(
        Long id,
        String name,
        int price,
        Long brandId,
        String brandName
) {
    public static ProductInfoResponseDto from(Product product) {
        return ProductInfoResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .brandId(product.getBrand().getId())
                .brandName(product.getBrand().getName())
                .build();
    }
}
