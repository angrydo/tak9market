package com.t9m.tak9market.product.controller;

import com.t9m.tak9market.common.dto.CommonResponse;
import com.t9m.tak9market.product.dto.ProductCreateRequestDto;
import com.t9m.tak9market.product.dto.ProductResponseDto;
import com.t9m.tak9market.product.dto.ProductUpdateRequestDto;
import com.t9m.tak9market.product.service.ProductReadService;
import com.t9m.tak9market.product.service.ProductWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductWriteService productWriteService;
    private final ProductReadService productReadService;

    @PostMapping("/api/v1/product/create")
    public ResponseEntity<CommonResponse<?>> createProduct(@RequestBody ProductCreateRequestDto requestDto) {
        ProductResponseDto responseDto = productWriteService.create(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.success(responseDto));
    }

    @PutMapping("/api/v1/product/update")
    public ResponseEntity<CommonResponse<?>> updateProduct(@RequestBody ProductUpdateRequestDto requestDto) {
        ProductResponseDto responseDto = productWriteService.update(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.success(responseDto));
    }

    @DeleteMapping("/api/v1/product/delete{id}")
    public ResponseEntity<CommonResponse<?>> deleteProduct(@PathVariable Long id) {
        ProductResponseDto responseDto = productWriteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.success(responseDto));
    }
}
