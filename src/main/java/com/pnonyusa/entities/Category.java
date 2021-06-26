package com.pnonyusa.entities;
/*
 * This java POJO Category entity that will be mapped as relational object
 * This entity classify the product
 *
 * */


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name="categories")
@Getter @Setter

public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productCategoryId;

    @Column(nullable = false)
    private String categoryName;


    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},
    mappedBy = "categories")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name="parent_id")
    @JsonIgnore
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> childCategories;

}
