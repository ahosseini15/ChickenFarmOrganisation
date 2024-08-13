package com.ChickenFarm.ChickenfarmOrganizr.repository;


import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChickenRepo extends JpaRepository<Chicken, Integer> {


    @Query("SELECT c FROM Chicken c WHERE c.chickenName = ?1 ")
    Chicken findByName(String name);
}
