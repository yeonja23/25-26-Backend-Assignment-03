package com.gdg.jpapractice.controller;

import com.gdg.jpapractice.dto.BrandInfoResponseDto;
import com.gdg.jpapractice.dto.BrandSaveRequestDto;
import com.gdg.jpapractice.global.common.response.BaseResponse;
import com.gdg.jpapractice.global.error.code.SuccessStatus;
import com.gdg.jpapractice.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    public BaseResponse<BrandInfoResponseDto> createBrand(@RequestBody BrandSaveRequestDto requestDto) {
        return BaseResponse.onSuccess(SuccessStatus.CREATED, brandService.save(requestDto));
    }

    @DeleteMapping("/{brandId}")
    public BaseResponse<Void> deleteBrandById(@PathVariable Long brandId) {
        brandService.delete(brandId);
        return BaseResponse.onSuccess(SuccessStatus.OK, null);
    }
}
