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

@RestController
@RequestMapping(path="/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Category> getAllCategories(){
        final List<Category> categories=categoryService.getAllCategories();
        return categories;
    }

    @RequestMapping(path="/{productCategoryId}",method = RequestMethod.GET)
    public Category getCategoryByProductCategoryId(@PathVariable String productCategoryId){
        final Category category=categoryService.getCategoryByProductCategoryId(productCategoryId)
                .orElseThrow(()->new NotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages()));
        return category;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category createCategory(@RequestBody  CategoryDto categoryDto){

        final Category category=categoryService.addCategory(categoryDto.getCategoryName());

        return category;
    }

}
