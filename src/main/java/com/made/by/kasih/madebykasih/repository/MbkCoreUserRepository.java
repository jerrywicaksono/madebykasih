package com.made.by.kasih.madebykasih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.made.by.kasih.madebykasih.model.MbkCoreUser;

@Repository
public interface MbkCoreUserRepository extends JpaRepository<MbkCoreUser, Long> {
	@Query(nativeQuery = true, value = "SELECT*FROM mbk_core_user where msisdn=:msisdn")
	MbkCoreUser getByMsisdn(@Param("msisdn")String msisdn);
}