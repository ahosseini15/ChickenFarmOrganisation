package com.ChickenFarm.ChickenfarmOrganizr.data.changing;


import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.CChange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CChangeDTO {

    private int id;
    private LocalDate dateOfChange;
    private int oldGroup;
    private int newGroup;
    private String chickenName;

    public static CChangeDTO chickenChangeDTO (@NonNull CChange cChange) {

        Chicken chicken = cChange.getChicken();

        return new CChangeDTO(
                cChange.getChickenChangeId(),
                cChange.getDateOfChange(),
                cChange.getOldGroup(),
                cChange.getNewGroup(),
                chicken == null ? null : chicken.getChickenName()
        );
    }
}
