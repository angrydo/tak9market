package com.t9m.tak9market.product.repository;

import com.t9m.tak9market.product.domain.Product;
import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 이름으로 검색 + 페이징 (이름에 keyword 포함, 대소문자 무시)
    Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
    // 카테고리별 조회 + 페이징
    Page<Product> findByCategory(String category, Pageable pageable);
}
