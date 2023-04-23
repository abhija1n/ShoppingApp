package com.projects.productservice.service.impl;

import com.projects.productservice.dto.ProductRequest;
import com.projects.productservice.dto.ProductResponse;
import com.projects.productservice.entity.Product;
import com.projects.productservice.repository.Productrepository;
import com.projects.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //at compile time it create all construct which we required construct argument
@Slf4j
public class ProductServiceImpl implements ProductService {

    //Constructor Injection
    private final Productrepository productrepository;


    @Override
    public void createProduct(ProductRequest productRequest) {
        //map product request to produc model
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        //save product in database
        productrepository.save(product);
        log.info("Product {} is saved successfully", product.getId());
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products= productrepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }
    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder().id(product.getId())
                .name(product.getId())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
