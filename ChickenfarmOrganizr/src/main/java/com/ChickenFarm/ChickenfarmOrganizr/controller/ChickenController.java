
package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CChangeServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.HgocServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.ChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Hgoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken")
@CrossOrigin
public class ChickenController {

   final  ChickenServiceImpl chickenService;
    final GroupServiceImpl groupService;
    final CChangeServiceImpl chickenChangeService;

    final HgocServiceImpl hgocService;




    @Autowired
    public ChickenController(ChickenServiceImpl chickenService, GroupServiceImpl groupService, CChangeServiceImpl chickenChangeService, HgocServiceImpl hgocService) {
        this.chickenService = chickenService;
        this.groupService = groupService;
        this.chickenChangeService = chickenChangeService;
        this.hgocService = hgocService;

    }

    @PostMapping("/add")
    public String add(@RequestBody ChickenDTO chickenDTO) {

        Chicken chicken = Chicken.chicken(chickenDTO);
        Group group = groupService.findById(chickenDTO.getGroupId());

        chicken.setGroup(group);
        chickenService.saveChicken(chicken);


        Hgoc hgoc = new Hgoc();

        hgoc.setChicken(chicken);
        hgoc.setGroup(chicken.getGroup());
        hgoc.setDateOfJoin(chicken.getChickenDateOfBirth());
        hgocService.saveHgoc(hgoc);


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
                 .map(ChickenDTO::chickenDTO)
                 .toList();

    }
}


