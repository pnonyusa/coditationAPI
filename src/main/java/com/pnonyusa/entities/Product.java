package com.pnonyusa.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*
* This java POJO product entity that will be mapped as relational object
* Products are associated with categeries either directly or indirectly
* */

@Entity(name="products")
@Setter @Getter
public class Product implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String productId;

    @Column(nullable=false)
    private String productName;

    @Column(nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private double price;

    private String image;

    private int quantityOnHand;


    @ManyToMany
    @JoinTable(name="product_category",joinColumns = @JoinColumn(name="prodId"),
    inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> categories;

}
