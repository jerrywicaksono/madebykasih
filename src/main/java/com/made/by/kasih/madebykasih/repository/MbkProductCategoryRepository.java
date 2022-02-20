package com.made.by.kasih.madebykasih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.made.by.kasih.madebykasih.model.MbkProductCategory;

@Repository
public interface MbkProductCategoryRepository extends JpaRepository<MbkProductCategory, Long> {
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_product_category order by category_name asc")
	List<MbkProductCategory> getAllCategory();
//	List<MbkProductCategory> getAllCategory(@Param("productColor")int productColor);
}