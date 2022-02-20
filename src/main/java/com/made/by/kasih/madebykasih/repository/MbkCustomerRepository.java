package com.made.by.kasih.madebykasih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.made.by.kasih.madebykasih.model.MbkCustomer;

@Repository
public interface MbkCustomerRepository extends JpaRepository<MbkCustomer, Long> {
	MbkCustomer findByFirstName(String firstName);
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_customer where UPPER(first_name)=UPPER(:firstName) AND UPPER(last_name)=UPPER(:lastName)")
	MbkCustomer findByFullName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_customer where msisdn=:msisdn")
	MbkCustomer findByMsisdn(@Param("msisdn")String msisdn);
}