package com.ChickenFarm.ChickenfarmOrganizr.model;


import com.ChickenFarm.ChickenfarmOrganizr.data.VaccinationOfOneChickenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Table(name = "vaccination_of_one_chicken")
@Entity
@Getter
@Setter
public class VaccinationOfOneChicken {


    public static VaccinationOfOneChicken vaccinationOfOneChicken(VaccinationOfOneChickenDTO vaccinationOfOneChickenDTO) {
    Objects.requireNonNull(vaccinationOfOneChickenDTO);

    VaccinationOfOneChicken vaccinationOfOneChicken = new VaccinationOfOneChicken();
         vaccinationOfOneChicken.voocId = vaccinationOfOneChickenDTO.getVoocId();
         vaccinationOfOneChicken.dateOfVaccination = vaccinationOfOneChickenDTO.getDateOfVaccination();
         vaccinationOfOneChicken.timeOfVaccination = vaccinationOfOneChickenDTO.getTimeOfVaccination();
         vaccinationOfOneChicken.crowdOfVaccination = vaccinationOfOneChickenDTO.getCrowdOfVaccination();
         vaccinationOfOneChicken.activeIngredient = vaccinationOfOneChickenDTO.getActiveIngredient();






    return  vaccinationOfOneChicken;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vooc_id")
    private int voocId;


    @ManyToOne
    @JoinColumn(name = "chicken_id")
    private Chicken chicken;

    @Column(name = "date_of_vaccination")
    private String dateOfVaccination;

    @Column(name = "active_ingredient")
    private String activeIngredient;

    @Column(name = "croud_of_vaccination")
    private String crowdOfVaccination;

    @Column(name = "time_of_vaccination")
    private String timeOfVaccination;

}
