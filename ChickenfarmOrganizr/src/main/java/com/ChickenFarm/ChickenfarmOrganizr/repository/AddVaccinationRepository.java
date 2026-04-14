package com.ChickenFarm.ChickenfarmOrganizr.repository;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddVaccinationRepository extends JpaRepository<Vaccination,Integer > {


    @Query("SELECT v FROM Vaccination v WHERE v.chicken.chickenid = :chickenId AND v.chicken.group.groupID = :groupId")
    List<Vaccination> findByChickenId(@Param("chickenId") int chickenId, @Param("groupId") int groupId);

}
