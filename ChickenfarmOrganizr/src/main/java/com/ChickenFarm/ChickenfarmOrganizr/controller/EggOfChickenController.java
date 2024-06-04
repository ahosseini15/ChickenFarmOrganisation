package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.EggOfChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.EggOfChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggOfChicken")
@CrossOrigin
public class EggOfChickenController {

    final EggOfChickenServiceImpl eggOfChickenService;
    final ChickenServiceImpl chickenService;
    final GroupServiceImpl groupService;

    public EggOfChickenController(EggOfChickenServiceImpl eggOfChickenService,
                                  ChickenServiceImpl chickenService,
                                  GroupServiceImpl groupService
                                    ) {

        this.chickenService = chickenService;
        this.eggOfChickenService = eggOfChickenService;
        this.groupService = groupService;

    }

    @PostMapping("/addEggChicken")
    public String SaveEggOfChicken(@RequestBody EggOfChickenDTO eggOfChickenDTO) {

        EggOfChicken eggOfChicken = EggOfChicken.eggOfChicken(eggOfChickenDTO);

        Chicken chicken = chickenService.findByName(eggOfChickenDTO.getChickenName());


         eggOfChicken.setChicken(chicken);
        eggOfChickenService.saveEggOfChicken(eggOfChicken);

        return "new Egg added";
    }


    @PostMapping("/addEggGroup")
    public String SaveEggsOfGroup(@RequestBody EggOfChickenDTO eggOfChickenDTO) {

        EggOfChicken eggOfChicken = EggOfChicken.eggOfChicken(eggOfChickenDTO);

       Group group =  groupService.findByName(eggOfChickenDTO.getGroupName());

        eggOfChicken.setGroup(group);
        eggOfChickenService.saveEggOfChicken(eggOfChicken);

        return "new Egg added";
    }


    @GetMapping("/getAll")
    public List<EggOfChickenDTO> get(){
        return eggOfChickenService.getAllEggOfChickens()
                .stream()
                .map(eggOfChickenEntity -> EggOfChickenDTO.eggOfChickenDTO(eggOfChickenEntity))
                .toList();
    }


}
