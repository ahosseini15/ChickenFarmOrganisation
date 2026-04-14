package com.ChickenFarm.ChickenfarmOrganizr.entity;


import com.ChickenFarm.ChickenfarmOrganizr.data.AddVaccinationsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


@Table(name = "vaccination_of_one_chicken")
@Entity
@Getter
@Setter
public class Vaccination {


    public static Vaccination vaccinationOfOneChicken(AddVaccinationsDTO addVaccinationsDTO) {
    Objects.requireNonNull(addVaccinationsDTO);

        Vaccination vaccination = new Vaccination();

         vaccination.voocId = addVaccinationsDTO.getVoocId();
         vaccination.dateOfVaccination = addVaccinationsDTO.getDateOfVaccination();
         vaccination.timeOfVaccination = addVaccinationsDTO.getTimeOfVaccination();
         vaccination.crowdOfVaccination = addVaccinationsDTO.getCrowdOfVaccination();
         vaccination.activeIngredient = addVaccinationsDTO.getActiveIngredient();




    return vaccination;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vooc_id")
    private int voocId;


    @ManyToOne
    @JoinColumn(name = "chicken_id")
    private Chicken chicken;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "date_of_vaccination")
    private LocalDate dateOfVaccination;

    @Column(name = "active_ingredient")
    private String activeIngredient;

    @Column(name = "croud_of_vaccination")
    private Integer crowdOfVaccination;

    @Column(name = "time_of_vaccination")
    private LocalTime timeOfVaccination;

}
