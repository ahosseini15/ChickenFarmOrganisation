package com.ChickenFarm.ChickenfarmOrganizr.repository;


import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Integer> {

    @Query("SELECT g FROM Group g WHERE g.groupName = ?1")


    Group findByName(String name);
}
