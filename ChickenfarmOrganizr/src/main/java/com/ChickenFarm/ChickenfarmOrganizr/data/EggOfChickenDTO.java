package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class EggOfChickenDTO {

    private int id;
    private String chickenName;
    private String groupName;
    private String dateOfPutEgg;
    private String size;
    private String timeOfPutEgg;
    private String croud;

    public static EggOfChickenDTO eggOfChickenDTO(@NonNull EggOfChicken eggOfChicken) {

            Chicken chicken = eggOfChicken.getChicken();
            Group group = eggOfChicken.getGroup();

            return new EggOfChickenDTO(
                    eggOfChicken.getEocId(),
                    eggOfChicken.getDateOfPutEgg(),
                    eggOfChicken.getSize(),
                    eggOfChicken.getTimeOfPutEgg(),
                    eggOfChicken.getCroud(),
                    chicken == null ? null : chicken.getChickenName(),
                    group == null ? null : group.getGroupName()

            );


    }


}
