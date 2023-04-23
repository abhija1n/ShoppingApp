package com.projects.productservice.service;

import com.projects.productservice.dto.ProductRequest;
import com.projects.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProduct();
}
