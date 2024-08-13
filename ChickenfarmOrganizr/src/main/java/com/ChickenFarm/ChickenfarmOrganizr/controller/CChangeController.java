package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.*;
import com.ChickenFarm.ChickenfarmOrganizr.data.changing.CChangeDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.changing.ChangingHistoryDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cChange")
@CrossOrigin
public class CChangeController {


    @Autowired
    private CChangeServiceImpl chickenChangeService;


    @Autowired
    private ChickenServiceImpl chickenService;


    @Autowired
    private GroupServiceImpl groupService;

    @Autowired
    private HgocServiceImpl hgocService;






    @PostMapping("/add")




    public String add(@RequestBody ChangingHistoryDTO changingHistoryDTO) {
 // Chicken History join wurde schon vorher asugefüllt
        Chicken chicken = chickenService.findByName(changingHistoryDTO.getCChangeDTO().getChickenName());
          Hgoc hgocUpdate = new Hgoc();
        Group groupHistory = groupService.findById(chicken.getGroup().getGroupID());



        CChange cChange = CChange.chickenChange(changingHistoryDTO.getCChangeDTO());

        hgocUpdate.setDateOfLeave(changingHistoryDTO.getCChangeDTO().getDateOfChange());
        hgocUpdate.setChicken(chicken);
        hgocUpdate.setGroup(groupHistory);
        hgocService.saveHgoc(hgocUpdate);




        cChange.setChicken(chicken);

        cChange.setOldGroup(chicken.getGroup().getGroupID());

        chickenChangeService.saveChickenChange(cChange);


        //update group of chicken
        Group group = groupService.findById(changingHistoryDTO.getCChangeDTO().getNewGroup());
        Chicken chickenToUpdate = chickenService.findByName(changingHistoryDTO.getCChangeDTO().getChickenName());
        chickenToUpdate.setGroup(group);
        chickenService.updateChicken(chickenToUpdate);

        Hgoc newHgocRow = Hgoc.HistorsxEntity(changingHistoryDTO.getHgocDTO());

       newHgocRow.setChicken(chickenToUpdate);
        newHgocRow.setDateOfJoin(cChange.getDateOfChange());
        newHgocRow.setGroup(chickenToUpdate.getGroup());


        hgocService.saveHgoc(newHgocRow);


























        return "chicken changed";



    }
    @GetMapping("/getAll")
    public List<CChangeDTO> get(){

        return chickenChangeService.getAllChangedChickens()
                .stream()
                .map(CChangeDTO::chickenChangeDTO)
                .toList();

    }
}
