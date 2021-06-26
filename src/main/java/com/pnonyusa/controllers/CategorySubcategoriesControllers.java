package com.pnonyusa.controllers;

import com.pnonyusa.entities.Category;
import com.pnonyusa.exception.ErrorMessages;
import com.pnonyusa.exception.NotFoundException;
import com.pnonyusa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* API endpoint for categories and subcategories association
* @author dev Phaphamani
* */

@RestController
@RequestMapping(path="/categories/{productCategoryId}/subcategories")
public class CategorySubcategoriesControllers {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method=RequestMethod.GET)
    public List<Category>getAllSubcategories(@PathVariable String productCategoryId){

        //getting all the requiring category;or throwing exception if not found
        final Category category=categoryService.getCategoryByProductCategoryId(productCategoryId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));

        return category.getChildCategories();

    }

    @RequestMapping(path = "/{childId}",method = RequestMethod.POST)
    public Category addSubcategory(@PathVariable String productCategoryId,@PathVariable String childId){

        //getting all the requiring category;or throwing exception if not found
        final Category category=categoryService.getCategoryByProductCategoryId(productCategoryId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));

        //getting all the requiring category;or throwing exception if not found
        final Category subcategory=categoryService.getCategoryByProductCategoryId(childId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));

        //validating if association deos not exists
        if(categoryService.isChildCategory(subcategory,category)){
            throw new IllegalArgumentException("category "+category.getProductCategoryId()+" already contains subcategory "+subcategory.getProductCategoryId());
        }

        //associating parent with subcategory..
        categoryService.addChildCategory(subcategory,category);

        return   category;
    }


}
