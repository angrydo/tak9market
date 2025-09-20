package com.t9m.tak9market.product.dto;

import com.t9m.tak9market.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private String Company;
    private String price;
    private String description;
    private String category;
    private Long stock;

    public ProductResponseDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.Company = entity.getCompany();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.category = entity.getCategory();
        this.stock = entity.getStock();
    }
}
