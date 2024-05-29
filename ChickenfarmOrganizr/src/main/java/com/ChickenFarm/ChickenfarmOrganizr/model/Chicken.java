package com.ChickenFarm.ChickenfarmOrganizr.model;

import com.ChickenFarm.ChickenfarmOrganizr.data.ChickenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Table(name = "chicken")
@Entity
@Getter
@Setter
public class Chicken {



    public  static  Chicken chicken (ChickenDTO chickenDTO) {

        Objects.requireNonNull(chickenDTO);

        Chicken chicken = new Chicken();

        chicken.chickenName = chickenDTO.getChickenName();
        chicken.chickenGender = chickenDTO.getChickenGender();
        chicken.chickenRace = chickenDTO.getChickenRace();
        chicken.chickenDateOfBirth = chickenDTO.getChickenDateOfBirth();
        chicken.chickenid = chickenDTO.getId();
        chicken.chickenDateOfDeath = chickenDTO.getChickenDateOfDeath();

        return chicken;
    }




    @Id
    @Column(name = "chicken_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chickenid;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "chicken_name")
    private String chickenName;

    @Column(name = "chicken_gender")
    private String chickenGender;

    @Column(name = "chicken_date_of_birth")
    private String chickenDateOfBirth;

    @Column(name = "chicken_race")
    private String chickenRace;

    @Column(name = "chicken_date_of_death")
    private String chickenDateOfDeath;

}
