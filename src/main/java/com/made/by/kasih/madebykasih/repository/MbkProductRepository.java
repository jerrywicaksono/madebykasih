package com.made.by.kasih.madebykasih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.made.by.kasih.madebykasih.model.MbkProduct;

@Repository
public interface MbkProductRepository extends JpaRepository<MbkProduct, Long> {
	List<MbkProduct> findByProductName(String productName);
	List<MbkProduct> findByProductCode(String productCode);
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_product where product_color=:productColor and product_name not in ('TERAZO ORANGE')")
	List<MbkProduct> findByProductColor(@Param("productColor")int productColor);
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_product where UPPER(product_name)=UPPER(:productName)")
	MbkProduct getByName(@Param("productName")String productName);
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_product where id=:id")
	MbkProduct getByIdProduct(@Param("id")Long id);
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_product order by product_name asc")
	List<MbkProduct> sortProduct(@Param("order")String order);
}