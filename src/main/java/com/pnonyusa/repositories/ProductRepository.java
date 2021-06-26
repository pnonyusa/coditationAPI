package com.pnonyusa.repositories;


import com.pnonyusa.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //SQL Native Queries being used to get categories assoscited either directly or indirectly

    String GET_PRODUCTS_ASSOCAITED_WITH_CATEGORY="SELECT p.* from products p inner join " +
            "product_category pc on p.id=pc.prodId" +
            " where (pc.categoryId =?1 or pc.categoryId in (select ac.id from ("
            +CategoryRepository.GET_RECURSIVELY_ALL_CHILDCATEGORIES+") ac where ac.parentid = ?1))";

    String COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY="select count(1) from ("+
            GET_PRODUCTS_ASSOCAITED_WITH_CATEGORY+")";


    //finds the product associted with the given category
    @Query(value = GET_PRODUCTS_ASSOCAITED_WITH_CATEGORY,
            countQuery = COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY,nativeQuery = true)
    Page<Product> findByAssociatedWithCategory(Long categoryId, Pageable pageable);


    //counts the number of products associated with the given category.
    @Query(value = COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY,nativeQuery = true)
    Long countByAssociatedWithCategory(Long categoryId);

    //finds the product by public product id
    Optional<Product>findByProductId(String productId);


}
