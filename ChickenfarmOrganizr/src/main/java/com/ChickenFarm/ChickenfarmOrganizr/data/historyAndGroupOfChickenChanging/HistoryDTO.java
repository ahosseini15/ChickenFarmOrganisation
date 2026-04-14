package com.ChickenFarm.ChickenfarmOrganizr.data.historyAndGroupOfChickenChanging;

import com.ChickenFarm.ChickenfarmOrganizr.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HistoryDTO {

    private int chickenHistoryId;
    private int chickenId;
    private int groupId;
    private int vaccination;
    private int eggs;
    private LocalDate dateOfJoin;
    private LocalDate dateOfLeave;

    public static HistoryDTO hgocDTO(@NonNull History history) {

        Chicken chicken = new Chicken();
        Group group = new Group();
        Vaccination vaccination = new Vaccination();
        Eggs eggs = new Eggs();

        return new HistoryDTO(
                history.getChickenHistoryId(),
                chicken.getChickenid(),
                group.getGroupID(),
                vaccination.getVoocId(),
                eggs.getEocId(),
                history.getDateOfJoin(),
                history.getDateOfLeave()
                );




    }







}
