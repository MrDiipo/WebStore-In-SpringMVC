package com.webstore.domain.Repository;

import com.webstore.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
}
