
package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.ChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken")
@CrossOrigin
public class ChickenController {

   final  ChickenServiceImpl chickenService;
    final GroupServiceImpl groupService;

    public ChickenController(ChickenServiceImpl chickenService, GroupServiceImpl groupService) {
        this.chickenService = chickenService;
        this.groupService = groupService;
    }

    @PostMapping("/add")
    public String add(@RequestBody ChickenDTO chickenDTO) {

        Chicken chicken = Chicken.chicken(chickenDTO);

        Group group = groupService.findByName(chickenDTO.getChickenGroupName());


           chicken.setGroup(group);

        chickenService.saveChicken(chicken);
        return "new chicken is added";

    }

    @PostMapping("/update")
    public String update(@RequestBody ChickenDTO chickenDTO) {


        Chicken chickenToUpdate = chickenService.findByName(chickenDTO.getChickenName());
        chickenToUpdate.setChickenDateOfDeath(chickenDTO.getChickenDateOfDeath());
        chickenService.updateChicken(chickenToUpdate);

        return "updated";
    }





    @GetMapping("/getAll")
    public List<ChickenDTO> get(){

         return chickenService.getAllChickens()
                 .stream()
                 .map(chickenEntity -> ChickenDTO.chickenDTO(chickenEntity))
                 .toList();

    }
}


