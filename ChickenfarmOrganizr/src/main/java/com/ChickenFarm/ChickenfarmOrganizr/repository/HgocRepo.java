package com.ChickenFarm.ChickenfarmOrganizr.repository;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Hgoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HgocRepo extends JpaRepository<Hgoc,Integer > {

    @Query("SELECT  DISTINCT g FROM Hgoc g  WHERE g.group.groupID = :groupId AND g.chicken.chickenid = :chickenId")
    Hgoc findHistory(@Param("groupId") Integer groupId, @Param("chickenId") int chickenId);


}
