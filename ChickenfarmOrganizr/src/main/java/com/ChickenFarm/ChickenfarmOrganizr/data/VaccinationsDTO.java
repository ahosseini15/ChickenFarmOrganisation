package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
public class VaccinationsDTO {

    private int voocId;
    private LocalDate dateOfVaccination;
    private String activeIngredient;
    private Integer crowdOfVaccination;
    private LocalTime timeOfVaccination;
    private String chickenName;
    private String GroupName;

    public static VaccinationsDTO vaccinationOfOneChickenDTO(@NonNull Vaccination vaccination){


    Chicken chicken = vaccination.getChicken();
    Group group = vaccination.getGroup();



    return new VaccinationsDTO(
            vaccination.getVoocId(),
            vaccination.getDateOfVaccination(),
            vaccination.getActiveIngredient(),
            vaccination.getCrowdOfVaccination(),
            vaccination.getTimeOfVaccination(),
            chicken.getChickenName(),
            group.getGroupName()

    );
}





}
