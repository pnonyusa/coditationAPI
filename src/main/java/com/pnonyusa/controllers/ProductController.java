package com.pnonyusa.controllers;

import com.pnonyusa.dto.ProductDto;
import com.pnonyusa.entities.Product;
import com.pnonyusa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
* API endpoint for product management
* @author dev Phaphamani
*
* */
@RestController
@RequestMapping(path="/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //get all products in the system
    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> getAllProducts(Pageable pageable){
        return productService.getAllProducts(pageable);
    }

    //create new product in system
    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody ProductDto productDto){

        Product product=new Product();

        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        product.setQuantityOnHand(productDto.getQuantityOnHand());

        return productService.createProduct(product);
    }


}
