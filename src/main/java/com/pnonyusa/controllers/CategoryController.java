package com.pnonyusa.controllers;


import com.pnonyusa.dto.CategoryDto;
import com.pnonyusa.entities.Category;
import com.pnonyusa.exception.ErrorMessages;
import com.pnonyusa.exception.NotFoundException;
import com.pnonyusa.resource.CategoryResponseModel;
import com.pnonyusa.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
* API endpoint for categories
* @author dev Phaphamani
* */
@RestController
@RequestMapping(path="/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //getting all categories in the system
    @RequestMapping(method= RequestMethod.GET)
    public List<Category> getAllCategories(){
        final List<Category> categories=categoryService.getAllCategories();
        return categories;
    }


    //getting the requiring category
    @RequestMapping(path="/{productCategoryId}",method = RequestMethod.GET)
    public Category getCategoryByProductCategoryId(@PathVariable String productCategoryId){

        //getting the requiring category;if not throwing exception
        final Category category=categoryService.getCategoryByProductCategoryId(productCategoryId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));
        return category;
    }

    //creating new category in the system
    @RequestMapping(method = RequestMethod.POST)
    public Category createCategory(@RequestBody  CategoryDto categoryDto){

        final Category category=categoryService.addCategory(categoryDto.getCategoryName());

        return category;
    }

}
