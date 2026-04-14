package com.ChickenFarm.ChickenfarmOrganizr.entity;

import com.ChickenFarm.ChickenfarmOrganizr.data.CreateChickenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "chicken")
@Entity
@Getter
@Setter
public class Chicken {



    public  static  Chicken chicken (CreateChickenDTO createChickenDTO) {

        Objects.requireNonNull(createChickenDTO);

        Chicken chicken = new Chicken();

        chicken.chickenName = createChickenDTO.getChickenName();
        chicken.chickenGender = createChickenDTO.getChickenGender();
        chicken.chickenRace = createChickenDTO.getChickenRace();
        chicken.chickenDateOfBirth = createChickenDTO.getChickenDateOfBirth();
        chicken.chickenid = createChickenDTO.getId();
        chicken.chickenDateOfDeath = createChickenDTO.getChickenDateOfDeath();

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
    private LocalDate chickenDateOfBirth;

    @Column(name = "chicken_race")
    private String chickenRace;

    @Column(name = "chicken_date_of_death")
    private LocalDate chickenDateOfDeath;

}
