package com.pnonyusa.repositories;

import com.pnonyusa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    //Recursive SQL query to fetch the number of Categories associated with a given category
    String GET_RECURSIVELY_ALL_CHILDCATEGORIES="WITH RECURSIVE ALL_CHILDCATEGORIES(ID,PARENTID)" +
            " AS (select c.id,c.parentid from categories c where c.parentid is null union all c.id,c.parentid " +
            "from ALL_CHILDCATEGORIES inner join categories c on ALL_CHILDCATEGORIES.id=c.parentid)=" +
            "select id,parentid from ALL_CHILDCATEGORIES";

    Optional<Category> findByProductCategoryId(String productCategoryId);
    Optional<Category> findByCategoryName(String categoryName);
}
