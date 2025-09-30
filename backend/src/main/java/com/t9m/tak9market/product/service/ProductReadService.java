package com.t9m.tak9market.product.service;

import com.t9m.tak9market.product.domain.Product;
import com.t9m.tak9market.product.dto.ProductResponseDto;
import com.t9m.tak9market.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductReadService {

    private final ProductRepository productRepository;

    // 상품 단순 조회
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + id));
        return new ProductResponseDto(product);
    }

    // 상품 이름 조회
    public Page<ProductResponseDto> searchByName(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<Product> products = productRepository.findByNameContainingIgnoreCase(keyword, pageable);
        return products.map(ProductResponseDto::new);
    }

    // 상품 카테고리별 조회
    public Page<ProductResponseDto> searchByCategory(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<Product> products = productRepository.findByCategory(category, pageable);
        return products.map(ProductResponseDto::new);
    }
}
