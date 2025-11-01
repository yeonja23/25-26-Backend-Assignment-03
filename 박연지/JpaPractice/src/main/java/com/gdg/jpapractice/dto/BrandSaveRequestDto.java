package com.gdg.jpapractice.dto;

public record BrandSaveRequestDto(
        String name,
        String country,
        int foundedAt
) {
}
