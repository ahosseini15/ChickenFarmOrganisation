package com.ChickenFarm.ChickenfarmOrganizr.repository;

import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EggOfChickenRepository extends JpaRepository<EggOfChicken,Integer> {

}
