package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.VaccinationOfOneChicken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor
public class VaccinationOfOneChickenDTO {

    private int voocId;
    private String dateOfVaccination;
    private String timeOfVaccination;
    private String activeIngredient;
    private String crowdOfVaccination;
    private String chickenName;

    public static VaccinationOfOneChickenDTO vaccinationOfOneChickenDTO(@NonNull VaccinationOfOneChicken vaccinationOfOneChicken){


    Chicken chicken = vaccinationOfOneChicken.getChicken();



    return new VaccinationOfOneChickenDTO(
            vaccinationOfOneChicken.getVoocId(),
            vaccinationOfOneChicken.getDateOfVaccination(),
            vaccinationOfOneChicken.getActiveIngredient(),
            vaccinationOfOneChicken.getCrowdOfVaccination(),
            vaccinationOfOneChicken.getTimeOfVaccination(),
            chicken.getChickenName()
    );
}





}
