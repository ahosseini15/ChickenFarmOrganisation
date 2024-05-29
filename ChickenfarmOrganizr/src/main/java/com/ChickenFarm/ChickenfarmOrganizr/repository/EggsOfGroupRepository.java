package com.ChickenFarm.ChickenfarmOrganizr.repository;

import com.ChickenFarm.ChickenfarmOrganizr.model.EggsOfGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggsOfGroupRepository extends JpaRepository<EggsOfGroup,Integer> {

}
