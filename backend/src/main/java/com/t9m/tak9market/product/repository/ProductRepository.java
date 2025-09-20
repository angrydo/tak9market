package com.t9m.tak9market.product.repository;

import com.t9m.tak9market.product.domain.Product;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ProductRepository extends JpaRepository<Product, Long> {

}
