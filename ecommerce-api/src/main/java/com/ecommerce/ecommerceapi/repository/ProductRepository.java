package com.ecommerce.ecommerceapi.repository;

import com.ecommerce.ecommerceapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
