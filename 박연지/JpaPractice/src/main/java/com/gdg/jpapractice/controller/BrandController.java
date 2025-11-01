package com.gdg.jpapractice.controller;

import com.gdg.jpapractice.dto.BrandInfoResponseDto;
import com.gdg.jpapractice.dto.BrandSaveRequestDto;
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
    public ResponseEntity<BrandInfoResponseDto> createBrand(@RequestBody BrandSaveRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.save(requestDto));
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteBrandById(@PathVariable Long brandId) {
        brandService.delete(brandId);
        return ResponseEntity.noContent().build();
    }
}
