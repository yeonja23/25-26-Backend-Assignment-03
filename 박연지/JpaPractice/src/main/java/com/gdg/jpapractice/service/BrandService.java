package com.gdg.jpapractice.service;

import com.gdg.jpapractice.domain.Brand;
import com.gdg.jpapractice.dto.BrandInfoResponseDto;
import com.gdg.jpapractice.dto.BrandSaveRequestDto;
import com.gdg.jpapractice.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    @Transactional
    public BrandInfoResponseDto save(BrandSaveRequestDto requestDto) {
        Brand brand = Brand.builder()
                .name(requestDto.name())
                .country(requestDto.country())
                .foundedAt(requestDto.foundedAt())
                .build();

        brandRepository.save(brand);
        return BrandInfoResponseDto.from(brand);
    }

    @Transactional
    public void delete(Long brandId) {
        if (!brandRepository.existsById(brandId)) {
            throw new IllegalArgumentException("삭제할 브랜드가 존재하지 않습니다. id=" + brandId);
        }
        brandRepository.deleteById(brandId);
    }
}
