package com.t9m.tak9market.product.service;

import com.t9m.tak9market.product.domain.Product;
import com.t9m.tak9market.product.dto.ProductResponseDto;
import com.t9m.tak9market.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductReadService {

    private final ProductRepository productRepository;

    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + id));
        return new ProductResponseDto(product);
    }

}
