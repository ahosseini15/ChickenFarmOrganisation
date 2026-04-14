package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.*;
import com.ChickenFarm.ChickenfarmOrganizr.data.historyAndGroupOfChickenChanging.GroupOfChickenChangingDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.historyAndGroupOfChickenChanging.CombinedChangingAndHistoryDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cChange")
@CrossOrigin
public class GroupOfChickenChangingController {


    @Autowired
    private GroupOfChickenChangingServiceImpl chickenChangeService;


    @Autowired
    private CreateChickenServiceImpl chickenService;


    @Autowired
    private CreateCreateGroupServiceImpl groupService;

    @Autowired
    private HistoyServiceImpl hgocService;






    @PostMapping("/add")




    public String add(@RequestBody CombinedChangingAndHistoryDTO changingHistoryDTO) {
 // Chicken History join wurde schon vorher asugefüllt
        Chicken chicken = chickenService.findByName(changingHistoryDTO.getGroupOfChickenChangingDTO().getChickenName());
          History historyUpdate = new History();
        Group groupHistory = groupService.findById(chicken.getGroup().getGroupID());



        GroupOfChickenChange groupOfChickenChange = GroupOfChickenChange.chickenChange(changingHistoryDTO.getGroupOfChickenChangingDTO());

        historyUpdate.setDateOfLeave(changingHistoryDTO.getGroupOfChickenChangingDTO().getDateOfChange());
        historyUpdate.setChicken(chicken);
        historyUpdate.setGroup(groupHistory);
        hgocService.saveHgoc(historyUpdate);




        groupOfChickenChange.setChicken(chicken);

        groupOfChickenChange.setOldGroup(chicken.getGroup().getGroupID());

        chickenChangeService.saveChickenChange(groupOfChickenChange);


        //update group of chicken
        Group group = groupService.findById(changingHistoryDTO.getGroupOfChickenChangingDTO().getNewGroup());
        Chicken chickenToUpdate = chickenService.findByName(changingHistoryDTO.getGroupOfChickenChangingDTO().getChickenName());
        chickenToUpdate.setGroup(group);
        chickenService.updateChicken(chickenToUpdate);

        History newHistoryRow = History.HistorsxEntity(changingHistoryDTO.getHistoryDTO());

       newHistoryRow.setChicken(chickenToUpdate);
        newHistoryRow.setDateOfJoin(groupOfChickenChange.getDateOfChange());
        newHistoryRow.setGroup(chickenToUpdate.getGroup());


        hgocService.saveHgoc(newHistoryRow);


























        return "chicken changed";



    }
    @GetMapping("/getAll")
    public List<GroupOfChickenChangingDTO> get(){

        return chickenChangeService.getAllChangedChickens()
                .stream()
                .map(GroupOfChickenChangingDTO::chickenChangeDTO)
                .toList();

    }
}
