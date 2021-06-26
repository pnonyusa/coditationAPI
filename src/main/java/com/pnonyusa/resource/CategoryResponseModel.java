package com.pnonyusa.resource;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CategoryResponseModel {

    private Long id;

    private String productCategoryId;

    private String categoryName;

    private List<ProductResponseModel> products;

    private CategoryResponseModel parent;

    private List<CategoryResponseModel> childCategories;

}
