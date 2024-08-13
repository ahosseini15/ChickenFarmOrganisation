package com.ChickenFarm.ChickenfarmOrganizr.data.changing;


import com.ChickenFarm.ChickenfarmOrganizr.entity.CChange;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangingHistoryDTO {

    private HgocDTO hgocDTO;

    private CChangeDTO cChangeDTO;



    public ChangingHistoryDTO changingHistoryDTO(CChange cChange) {

        return new ChangingHistoryDTO(
             hgocDTO,
             cChangeDTO
        );
    }
}
