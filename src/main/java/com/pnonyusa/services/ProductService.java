package com.pnonyusa.services;

import com.pnonyusa.entities.Category;
import com.pnonyusa.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service for {@link Product} entity
 * @author dev Phaphamani
 * */
public interface ProductService {

    /**
    * getting all product in the system
    * The results is paginated
    *
    * @param page the page to fetch the results from
    * @return the paginated results
    * */
    Page<Product> getAllProducts(Pageable page);

    /**
     * gets all products that are associated with the given category
     * The association can be either directly or indirectly
     *
     * @param category the category to filter
     * @param page the page to fetch the results from
     * @return the paginated results
     */
    Page<Product> getAllProducts(Category category,Pageable page);


    /**
     * gets specific product by looking its productId
     *
     * @param productId the productId of product to look for
     * @return the product (if any)
     *
     * */
    Optional<Product>getProductByProductId(String productId);

    /**
     * create new product in system
     *
     * @param  product to be created
     * @return the created product
     * */
    Product createProduct(Product product);


    /**
     * checks whether the product has a given category
     *
     * @param product the product to check
     * @param category the category to check
     * @return true if the product is associated to the category
     * */
    boolean hasCategory(Product product,Category category);

    /**
     * checks whether or not a given category has products associated.
     * The association can be either directly or indirectly
     *
     * @param category the category to check
     * */
    boolean hasProductsAssocaited(Category category);

    /**
     *Adds a category to the product
     *
     * @param product the product to add the category to
     * @param category the category to add
     * */
    void addCategory(Product product,Category category);

}
