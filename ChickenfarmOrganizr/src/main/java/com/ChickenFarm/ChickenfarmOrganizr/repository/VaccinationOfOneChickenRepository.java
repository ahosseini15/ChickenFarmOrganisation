package com.ChickenFarm.ChickenfarmOrganizr.repository;

import com.ChickenFarm.ChickenfarmOrganizr.model.VaccinationOfOneChicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationOfOneChickenRepository extends JpaRepository<VaccinationOfOneChicken,Integer > {
}
