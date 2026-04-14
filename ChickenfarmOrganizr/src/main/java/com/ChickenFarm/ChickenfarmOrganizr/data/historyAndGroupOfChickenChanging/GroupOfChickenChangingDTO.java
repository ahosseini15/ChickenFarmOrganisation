package com.ChickenFarm.ChickenfarmOrganizr.data.historyAndGroupOfChickenChanging;


import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.GroupOfChickenChange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GroupOfChickenChangingDTO {

    private int id;
    private LocalDate dateOfChange;
    private int oldGroup;
    private int newGroup;
    private String chickenName;

    public static GroupOfChickenChangingDTO chickenChangeDTO (@NonNull GroupOfChickenChange groupOfChickenChange) {

        Chicken chicken = groupOfChickenChange.getChicken();

        return new GroupOfChickenChangingDTO(
                groupOfChickenChange.getChickenChangeId(),
                groupOfChickenChange.getDateOfChange(),
                groupOfChickenChange.getOldGroup(),
                groupOfChickenChange.getNewGroup(),
                chicken == null ? null : chicken.getChickenName()
        );
    }
}
