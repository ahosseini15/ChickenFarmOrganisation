
package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupOfChickenChangingServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateCreateGroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.HistoyServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.CreateChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken")
@CrossOrigin
public class CreateChickenController {

   final CreateChickenServiceImpl chickenService;
    final CreateCreateGroupServiceImpl groupService;
    final GroupOfChickenChangingServiceImpl chickenChangeService;

    final HistoyServiceImpl hgocService;




    @Autowired
    public CreateChickenController(CreateChickenServiceImpl chickenService, CreateCreateGroupServiceImpl groupService, GroupOfChickenChangingServiceImpl chickenChangeService, HistoyServiceImpl hgocService) {
        this.chickenService = chickenService;
        this.groupService = groupService;
        this.chickenChangeService = chickenChangeService;
        this.hgocService = hgocService;

    }

    @PostMapping("/add")
    public String add(@RequestBody CreateChickenDTO createChickenDTO) {

        Chicken chicken = Chicken.chicken(createChickenDTO);
        Group group = groupService.findById(createChickenDTO.getGroupId());

        chicken.setGroup(group);
        chickenService.saveChicken(chicken);


        History history = new History();

        history.setChicken(chicken);
        history.setGroup(chicken.getGroup());
        history.setDateOfJoin(chicken.getChickenDateOfBirth());
        hgocService.saveHgoc(history);


        return "new chicken is added";

    }

    @PostMapping("/update")
    public String update(@RequestBody CreateChickenDTO createChickenDTO) {


        Chicken chickenToUpdate = chickenService.findByName(createChickenDTO.getChickenName());
        chickenToUpdate.setChickenDateOfDeath(createChickenDTO.getChickenDateOfDeath());
        chickenService.updateChicken(chickenToUpdate);

        return "updated";
    }





    @GetMapping("/getAll")
    public List<CreateChickenDTO> get(){

         return chickenService.getAllChickens()
                 .stream()
                 .map(CreateChickenDTO::chickenDTO)
                 .toList();

    }
}


