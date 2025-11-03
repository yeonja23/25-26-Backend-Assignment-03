package com.gdg.jpapractice.controller;

import com.gdg.jpapractice.dto.ProductInfoResponseDto;
import com.gdg.jpapractice.dto.ProductSaveRequestDto;
import com.gdg.jpapractice.global.common.response.BaseResponse;
import com.gdg.jpapractice.global.error.code.SuccessStatus;
import com.gdg.jpapractice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public BaseResponse<ProductInfoResponseDto> createProduct(@RequestBody ProductSaveRequestDto requestDto) {
        return BaseResponse.onSuccess(SuccessStatus.CREATED, productService.save(requestDto));
    }

    @GetMapping
    public BaseResponse<List<ProductInfoResponseDto>> getAllProducts() {
        return BaseResponse.onSuccess(SuccessStatus.OK, productService.findAll());
    }

    @GetMapping("/{productId}")
    public BaseResponse<ProductInfoResponseDto> getProductById(@PathVariable Long productId) {
        return BaseResponse.onSuccess(SuccessStatus.OK, productService.findById(productId));
    }

    @PatchMapping("/{productId}")
    public BaseResponse<ProductInfoResponseDto> updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductSaveRequestDto requestDto
    ) {
        return BaseResponse.onSuccess(SuccessStatus.OK, productService.update(productId, requestDto));
    }

    @DeleteMapping("/{productId}")
    public BaseResponse<Void> deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        return BaseResponse.onSuccess(SuccessStatus.OK, null);
    }
}

