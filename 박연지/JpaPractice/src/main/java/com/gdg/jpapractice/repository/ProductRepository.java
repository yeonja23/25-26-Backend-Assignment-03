package com.gdg.jpapractice.repository;

import com.gdg.jpapractice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
