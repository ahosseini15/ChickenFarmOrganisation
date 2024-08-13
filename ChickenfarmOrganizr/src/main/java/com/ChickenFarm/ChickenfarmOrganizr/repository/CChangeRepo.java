package com.ChickenFarm.ChickenfarmOrganizr.repository;

import com.ChickenFarm.ChickenfarmOrganizr.entity.CChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CChangeRepo extends JpaRepository<CChange,Integer> {

}
