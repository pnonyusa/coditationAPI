package com.pnonyusa.services.implemantation;

import com.pnonyusa.entities.Category;
import com.pnonyusa.exception.ErrorMessages;
import com.pnonyusa.exception.NotFoundException;
import com.pnonyusa.repositories.CategoryRepository;
import com.pnonyusa.services.CategoryService;
import com.pnonyusa.shared.dto.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.awt.geom.NoninvertibleTransformException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    @Transactional
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Transactional
    @Override
    public Optional<Category> getCategoryByProductCategoryId(String productCategoryId) {
        return categoryRepository.findByProductCategoryId(productCategoryId) ;
    }



    @Transactional
    @Override
    public Category addCategory(String categoryName) {

        Category category=categoryRepository.findByCategoryName(categoryName).get();

        if(categoryName.equals(category.getCategoryName())) throw new NotFoundException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessages());

        category.setCategoryName(categoryName);

        category.setProductCategoryId(new Utils().generateId(5));

        return categoryRepository.save(category);
    }

    @Transactional
    @Override
    public boolean isChildCategory(Category child, Category parent) {
        return child.getParent().equals(parent);
    }



    @Transactional
    @Override
    public void addChildCategory(Category category, Category parent) {

             if(category==null) throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());

             category.setParent(parent);
             categoryRepository.save(category);
    }
}
