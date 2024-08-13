package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.EggsServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.HgocServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.EggsDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Hgoc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggs")
@CrossOrigin
public class EggsController {

    final EggsServiceImpl eggOfChickenService;
    final ChickenServiceImpl chickenService;
    final GroupServiceImpl groupService;

    final HgocServiceImpl hgocService;

    public EggsController(EggsServiceImpl eggOfChickenService,
                          ChickenServiceImpl chickenService,
                          GroupServiceImpl groupService,
                          HgocServiceImpl hgocService
                                    ) {

        this.chickenService = chickenService;
        this.eggOfChickenService = eggOfChickenService;
        this.groupService = groupService;
        this.hgocService = hgocService;

    }

    @PostMapping("/addEggChicken")
    public String SaveEggOfChicken(@RequestBody EggsDTO eggsDTO) {

        Eggs eggs = Eggs.eggOfChicken(eggsDTO);

        Chicken chicken = chickenService.findByName(eggsDTO.getChickenName());


         eggs.setChicken(chicken);
        eggOfChickenService.saveEggOfChicken(eggs);

        Hgoc hgoc = new Hgoc();

        hgoc.setEggs(eggs);
        hgoc.setChicken(chicken);
        hgoc.setGroup(chicken.getGroup());
        hgocService.saveHgoc(hgoc);



        return "new Egg added";
    }







    @PostMapping("/addEggGroup")
    public String SaveEggsOfGroup(@RequestBody EggsDTO eggsDTO) {

        Eggs eggs = Eggs.eggOfChicken(eggsDTO);

       Group group =  groupService.findByName(eggsDTO.getGroupName());

        eggs.setGroup(group);
        eggOfChickenService.saveEggOfChicken(eggs);


        return "new Egg added";
    }


    @GetMapping("/getAll")
    public List<EggsDTO> get(){
        return eggOfChickenService.getAllEggOfChickens()
                .stream()
                .map(eggOfChickenEntity -> EggsDTO.eggOfChickenDTO(eggOfChickenEntity))
                .toList();
    }


}
