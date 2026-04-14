package com.ChickenFarm.ChickenfarmOrganizr.data.historyAndGroupOfChickenChanging;


import com.ChickenFarm.ChickenfarmOrganizr.entity.GroupOfChickenChange;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombinedChangingAndHistoryDTO {

    private HistoryDTO historyDTO;

    private GroupOfChickenChangingDTO groupOfChickenChangingDTO;



    public CombinedChangingAndHistoryDTO changingHistoryDTO(GroupOfChickenChange groupOfChickenChange) {

        return new CombinedChangingAndHistoryDTO(
                historyDTO,
                groupOfChickenChangingDTO
        );
    }
}
