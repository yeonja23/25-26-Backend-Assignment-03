package com.gdg.jpapractice.dto;

import com.gdg.jpapractice.domain.Brand;
import lombok.Builder;

@Builder
public record BrandInfoResponseDto(
        Long id,
        String name,
        String country,
        int foundedAt
) {
    public static BrandInfoResponseDto from(Brand brand) {
        return BrandInfoResponseDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .country(brand.getCountry())
                .foundedAt(brand.getFoundedAt())
                .build();
    }
}
