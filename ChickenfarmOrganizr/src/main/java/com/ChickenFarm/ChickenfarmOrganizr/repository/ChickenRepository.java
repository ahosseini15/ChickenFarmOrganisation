package com.ChickenFarm.ChickenfarmOrganizr.repository;


import com.ChickenFarm.ChickenfarmOrganizr.model.chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChickenRepository extends JpaRepository<chicken, Integer> {
}
