package com.gdg.jpapractice.dto;

public record ProductSaveRequestDto(
        Long brandId,
        String name,
        int price
) {
}
