package com.ChickenFarm.ChickenfarmOrganizr.repository;


import com.ChickenFarm.ChickenfarmOrganizr.model.groupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupTableRepository extends JpaRepository<groupTable, Integer> {
}
