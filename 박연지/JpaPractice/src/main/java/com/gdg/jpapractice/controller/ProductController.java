package com.gdg.jpapractice.controller;

import com.gdg.jpapractice.dto.ProductInfoResponseDto;
import com.gdg.jpapractice.dto.ProductSaveRequestDto;
import com.gdg.jpapractice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductInfoResponseDto> createProduct(@RequestBody ProductSaveRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductInfoResponseDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductInfoResponseDto> getProductById(@PathVariable Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(productId));
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductInfoResponseDto> updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductSaveRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(productId, requestDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}

