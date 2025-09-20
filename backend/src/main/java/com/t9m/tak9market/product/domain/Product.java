package com.t9m.tak9market.product.domain;

import com.t9m.tak9market.product.dto.ProductUpdateRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String company;
    private String price;
    private String description;
    private String category;
    private Long stock;

    public Product update(ProductUpdateRequestDto requestDto) {
        this.name = requestDto.getName();
        this.company = requestDto.getCompany();
        this.price = requestDto.getPrice();
        this.description = requestDto.getDescription();
        this.category = requestDto.getCategory();
        this.stock = requestDto.getStock();
        return this;
    }
}
