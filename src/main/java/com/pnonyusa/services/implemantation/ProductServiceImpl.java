package com.pnonyusa.services.implemantation;

import com.pnonyusa.entities.Category;
import com.pnonyusa.entities.Product;
import com.pnonyusa.exception.ErrorMessages;
import com.pnonyusa.repositories.ProductRepository;
import com.pnonyusa.services.ProductService;

import com.pnonyusa.shared.dto.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    @Override
    public Page<Product> getAllProducts(Pageable page) {
        return productRepository.findAll(page);
    }

    @Transactional
    @Override
    public Page<Product> getAllProducts(Category category, Pageable page) {

        if(category==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());

        return productRepository.findByAssociatedWithCategory(category.getId(),page);
    }

    @Transactional
    @Override
    public Optional<Product> getProductByProductId(String productId) {

        if(productId==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());

        return productRepository.findByProductId(productId);
    }

    @Transactional
    @Override
    public Product createProduct(Product product) {

        if(product==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());

        product.setProductId(new Utils().generateId(6));

        return productRepository.save(product);
    }




    @Transactional
    @Override
    public boolean hasCategory(Product product, Category category) {
        return product.getCategories().contains(category);
    }



    @Transactional
    @Override
    public boolean hasProductsAssocaited(Category category) {
        return productRepository.countByAssociatedWithCategory(category.getId())>0;
    }

    @Transactional
    @Override
    public void addCategory(Product product, Category category) {

        if(product==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());

        product.getCategories().add(category);

        productRepository.save(product);

    }
}
