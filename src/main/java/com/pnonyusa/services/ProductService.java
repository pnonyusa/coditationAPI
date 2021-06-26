package com.pnonyusa.services;

import com.pnonyusa.entities.Category;
import com.pnonyusa.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<Product> getAllProducts(Pageable page);

    Page<Product> getAllProducts(Category category,Pageable page);

    Optional<Product>getProductByProductId(String productId);

    Product createProduct(Product product);

    boolean hasCategory(Product product,Category category);

    boolean hasProductsAssocaited(Category category);

    void addCategory(Product product,Category category);

}
