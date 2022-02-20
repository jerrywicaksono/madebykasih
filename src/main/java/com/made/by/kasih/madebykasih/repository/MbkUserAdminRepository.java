package com.made.by.kasih.madebykasih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.made.by.kasih.madebykasih.model.MbkUserAdmin;

@Repository
public interface MbkUserAdminRepository extends JpaRepository<MbkUserAdmin, Long> {

}