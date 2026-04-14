package com.ChickenFarm.ChickenfarmOrganizr.repository;
import com.ChickenFarm.ChickenfarmOrganizr.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends JpaRepository<History,Integer > {

    @Query("SELECT  DISTINCT g FROM History g  WHERE g.group.groupID = :groupId AND g.chicken.chickenid = :chickenId")
    History findHistory(@Param("groupId") Integer groupId, @Param("chickenId") int chickenId);


}
