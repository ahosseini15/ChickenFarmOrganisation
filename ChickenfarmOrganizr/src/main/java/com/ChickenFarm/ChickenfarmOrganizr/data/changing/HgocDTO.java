package com.ChickenFarm.ChickenfarmOrganizr.data.changing;

import com.ChickenFarm.ChickenfarmOrganizr.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HgocDTO {

    private int chickenHistoryId;
    private int chickenId;
    private int groupId;
    private int vaccination;
    private int eggs;
    private LocalDate dateOfJoin;
    private LocalDate dateOfLeave;

    public static HgocDTO hgocDTO(@NonNull Hgoc hgoc) {

        Chicken chicken = new Chicken();
        Group group = new Group();
        Vaccination vaccination = new Vaccination();
        Eggs eggs = new Eggs();

        return new HgocDTO(
                hgoc.getChickenHistoryId(),
                chicken.getChickenid(),
                group.getGroupID(),
                vaccination.getVoocId(),
                eggs.getEocId(),
                hgoc.getDateOfJoin(),
                hgoc.getDateOfLeave()
                );




    }







}
