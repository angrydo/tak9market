package com.t9m.tak9market.product.service;

import com.t9m.tak9market.common.exception.CustomNotFoundException;
import com.t9m.tak9market.common.exception.CustomValidateException;
import com.t9m.tak9market.product.domain.Product;
import com.t9m.tak9market.product.dto.ProductCreateRequestDto;
import com.t9m.tak9market.product.dto.ProductResponseDto;
import com.t9m.tak9market.product.dto.ProductUpdateRequestDto;
import com.t9m.tak9market.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductWriteService {

    private final ProductRepository productRepository;

    public ProductResponseDto create(ProductCreateRequestDto requestDto) {
        if (requestDto.getName() == null || requestDto.getName().isEmpty())
            throw new CustomValidateException("The product must have a name.");
        if (requestDto.getCompany() == null || requestDto.getCompany().isEmpty())
            throw new CustomValidateException("The company must have a name.");
        if (requestDto.getPrice() == null || requestDto.getPrice().isEmpty())
            throw new CustomValidateException("The price must not be empty.");
        if (requestDto.getDescription() == null || requestDto.getDescription().isEmpty())
            throw new CustomValidateException("The description must not be empty.");
        if (requestDto.getCategory() == null || requestDto.getCategory().isEmpty())
            throw new CustomValidateException("The category must not be empty.");
        if (requestDto.getStock() == null)
            throw new CustomValidateException("The stock must not be null or under 0.");
        return new ProductResponseDto(productRepository.save(requestDto.toEntity()));
    }

    public ProductResponseDto update(ProductUpdateRequestDto requestDto) {
        if (requestDto.getName() == null || requestDto.getName().isEmpty())
            throw new CustomValidateException("The product must have a name.");
        if (requestDto.getCompany() == null || requestDto.getCompany().isEmpty())
            throw new CustomValidateException("The company must not be empty.");
        if (requestDto.getPrice() == null || requestDto.getPrice().isEmpty())
            throw new CustomValidateException("The price must not be zero or empty.");
        if (requestDto.getDescription() == null || requestDto.getDescription().isEmpty())
            throw new CustomValidateException("The description must not be empty.");
        if (requestDto.getCategory() == null || requestDto.getCategory().isEmpty())
            throw new CustomValidateException("The category must not be empty.");
        if (requestDto.getStock() == null)
            throw new CustomValidateException("The stock must not be null or under 0.");

        Product entity = productRepository.findById(requestDto.getId()).orElseThrow(
                () -> new CustomNotFoundException("Post not found with id: " + requestDto.getId()));
        return new ProductResponseDto(productRepository.save(entity.update(requestDto)));
    }

    public ProductResponseDto delete(Long id) {
        Product entity = productRepository.findById(id).orElseThrow(
                () -> new CustomNotFoundException("Product not found with id: " + id));
        productRepository.deleteById(id);
        return new ProductResponseDto(entity);
    }
}
