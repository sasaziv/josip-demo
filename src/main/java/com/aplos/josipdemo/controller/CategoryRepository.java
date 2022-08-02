package com.aplos.josipdemo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT COUNT(*) FROM product p join category c on p.category_id=c.id where c.id=:id", nativeQuery = true)
	Integer countProductsInCategory(@Param("id") Integer id);

}
