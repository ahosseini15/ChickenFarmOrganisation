package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class EggOfChickenDTO {

    private int id;
    private String dateOfPutEgg;
    private String size;
    private String chickenName;
    private String timeOfPutEgg;

    public static EggOfChickenDTO eggOfChickenDTO(@NonNull EggOfChicken eggOfChicken) {

            Chicken chicken = eggOfChicken.getChicken();

            return new EggOfChickenDTO(
                    eggOfChicken.getEocId(),
                    eggOfChicken.getDateOfPutEgg(),
                    eggOfChicken.getSize(),
                    eggOfChicken.getTimeOfPutEgg(),
                    chicken == null ? null : chicken.getChickenName()
            );


    }


}
