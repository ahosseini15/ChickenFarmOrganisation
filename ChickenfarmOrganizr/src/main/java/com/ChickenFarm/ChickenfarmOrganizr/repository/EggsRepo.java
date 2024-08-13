package com.ChickenFarm.ChickenfarmOrganizr.repository;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggsRepo extends JpaRepository<Eggs,Integer> {

}
