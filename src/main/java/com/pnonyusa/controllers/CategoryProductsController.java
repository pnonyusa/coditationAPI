package com.pnonyusa.controllers;

import com.pnonyusa.entities.Category;
import com.pnonyusa.entities.Product;
import com.pnonyusa.exception.ErrorMessages;
import com.pnonyusa.exception.NotFoundException;
import com.pnonyusa.services.CategoryService;
import com.pnonyusa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


/**
* API endpoint for categories and product association
* @author dev Phaphamani
* */

@RestController
@RequestMapping(path="/categories/{productCategoryId}/products")
public class CategoryProductsController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    //getting all products in the system
    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> getAllProducts(@PathVariable String productCategoryId, Pageable pageable){
        //getting the requiring category;or throwing exception if not found
        final Category category=categoryService.getCategoryByProductCategoryId(productCategoryId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));
        return productService.getAllProducts(category,pageable);
    }


    //associating product with category
    @RequestMapping(path = "/{productId}",method = RequestMethod.POST)
    public Product addProduct(@PathVariable String productCategoryId,@PathVariable String productId){

        //getting the requiring category;or throwing exception if not found
        final Category category=categoryService.getCategoryByProductCategoryId(productCategoryId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));

        //getting the requiring product;or throwing exception if not found
        final Product product=productService.getProductByProductId(productId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));

        //validating if association does not exists
        if(productService.hasCategory(product,category)){
            throw new IllegalArgumentException("product "+product.getProductId()+" already contains category "+category.getProductCategoryId());

        }

        productService.addCategory(product,category);

        return product;
    }
}
