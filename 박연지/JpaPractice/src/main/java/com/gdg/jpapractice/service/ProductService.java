package com.gdg.jpapractice.service;

import com.gdg.jpapractice.domain.Brand;
import com.gdg.jpapractice.domain.Product;
import com.gdg.jpapractice.dto.ProductInfoResponseDto;
import com.gdg.jpapractice.dto.ProductSaveRequestDto;
import com.gdg.jpapractice.global.error.code.ErrorStatus;
import com.gdg.jpapractice.global.exception.GeneralException;
import com.gdg.jpapractice.repository.BrandRepository;
import com.gdg.jpapractice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    // 상품 등록
    @Transactional
    public ProductInfoResponseDto save(ProductSaveRequestDto requestDto) {
        Brand brand = brandRepository.findById(requestDto.brandId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.BRAND_NOT_FOUND));

        Product product = Product.builder()
                .brand(brand)
                .name(requestDto.name())
                .price(requestDto.price())
                .build();

        productRepository.save(product);
        return ProductInfoResponseDto.from(product);
    }

    // 상품 전체 조회
    @Transactional(readOnly = true)
    public List<ProductInfoResponseDto> findAll() {
        return productRepository.findAllWithBrand()
                .stream()
                .map(ProductInfoResponseDto::from)
                .toList();
    }

    // 상품 단건 조회
    @Transactional(readOnly = true)
    public ProductInfoResponseDto findById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.PRODUCT_NOT_FOUND));
        return ProductInfoResponseDto.from(product);
    }

    // 상품 수정
    @Transactional
    public ProductInfoResponseDto update(Long productId, ProductSaveRequestDto requestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.PRODUCT_NOT_FOUND));

        Brand brand = brandRepository.findById(requestDto.brandId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.BRAND_NOT_FOUND));

        product.update(brand, requestDto.name(), requestDto.price());
        return ProductInfoResponseDto.from(product);
    }

    // 상품 삭제
    @Transactional
    public void delete(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new GeneralException(ErrorStatus.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(productId);
    }
}
