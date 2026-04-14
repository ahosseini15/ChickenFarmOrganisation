package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class AddEggsDTO {

    private int id;
    private LocalDate dateOfPutEgg;
    private String size;
    private LocalTime timeOfPutEgg;
    private Integer croud;
    private String chickenName;
    private String groupName;
    public static AddEggsDTO eggOfChickenDTO(@NonNull Eggs eggs) {

            Chicken chicken = eggs.getChicken();
            Group group = eggs.getGroup();

            return new AddEggsDTO(
                    eggs.getEocId(),
                    eggs.getDateOfPutEgg(),
                    eggs.getSize(),
                    eggs.getTimeOfPutEgg(),
                    eggs.getCroud(),
                    chicken == null ? null : chicken.getChickenName(),
                    group == null ? null : group.getGroupName()

            );


    }


}
