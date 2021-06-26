package com.pnonyusa.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
    private String productName;
    private String productDescription;
    private double price;
    private String image;
    private int quantityOnHand;
}
