
package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ChickenDTO {

        private int id;
        private String chickenName;
        private String chickenDateOfBirth;
        private String chickenGender;
        private String chickenRace;
        private String chickenGroupName;
        private String chickenDateOfDeath;
        public static ChickenDTO chickenDTO(@NonNull Chicken chicken) {
        Group group = chicken.getGroup();

                return new ChickenDTO(
                        chicken.getChickenid(),
                        chicken.getChickenName(),
                        chicken.getChickenDateOfBirth() ,
                        chicken.getChickenGender() ,
                        chicken.getChickenRace(),
                        chicken.getChickenDateOfDeath(),
                        group == null ? null : group.getGroupName()
                                        );

        }





}


