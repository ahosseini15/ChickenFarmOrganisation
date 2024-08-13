
package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ChickenDTO {

        private int id;
        private String chickenName;
        private LocalDate chickenDateOfBirth;
        private String chickenGender;
        private String chickenRace;
        private LocalDate chickenDateOfDeath;
        private int groupId;

        public static ChickenDTO chickenDTO(@NonNull Chicken chicken) {

        Group group = chicken.getGroup();

                return new ChickenDTO(
                        chicken.getChickenid(),
                        chicken.getChickenName(),
                        chicken.getChickenDateOfBirth() ,
                        chicken.getChickenGender() ,
                        chicken.getChickenRace(),
                        chicken.getChickenDateOfDeath(),
                         group.getGroupID()
                                        );

        }





}


