package com.pnonyusa.services;

import com.pnonyusa.entities.Category;


import java.util.List;
import java.util.Optional;

/**
* Service for {@link Category} entity
* @author dev Phaphamani
* */
public interface CategoryService {

    /**
    * retreives all categories present on the application
    *
    * @return all categories
    * */
    List<Category> getAllCategories();

    /**
    * Gets a specific category by looking for its id
    */
    Optional<Category> getCategoryByProductCategoryId(String productCategoryId);

    /**
    * Creates category
    *@param categoryName name to the category
    *@return new category
    */
    Category addCategory(String categoryName);

    /**
     * it checks whether the given categories are associated each other
     *
     *@param child the child category to check
     *@param parent category to check
     * @ return true if the child category is associated with the parent
     *
     */
     boolean isChildCategory(Category child,Category parent);

     /**
     * Adds the child category into the given parent category
     *
     * @param child the child category to add
     * @param parent the parent category to add the child to
     * */
     void addChildCategory(Category child,Category parent);

}
