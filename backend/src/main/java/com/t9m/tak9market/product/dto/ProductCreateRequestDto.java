package com.t9m.tak9market.product.dto;

import com.t9m.tak9market.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequestDto {
    private String name;
    private String Company;
    private String price;
    private String description;
    private String category;
    private Long stock;

    public Product toEntity() {
        return Product.builder()
                .name(this.name)
                .company(this.Company)
                .price(this.price)
                .description(this.description)
                .category(this.category)
                .stock(this.stock)
                .build();
    }
}