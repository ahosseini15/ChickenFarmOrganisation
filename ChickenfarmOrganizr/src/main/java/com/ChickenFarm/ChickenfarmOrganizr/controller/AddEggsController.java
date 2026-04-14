package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.AddAddEggsServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateCreateGroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.HistoyServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.AddEggsDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.History;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggs")
@CrossOrigin
public class AddEggsController {

    final AddAddEggsServiceImpl eggOfChickenService;
    final CreateChickenServiceImpl chickenService;
    final CreateCreateGroupServiceImpl groupService;

    final HistoyServiceImpl hgocService;

    public AddEggsController(AddAddEggsServiceImpl eggOfChickenService,
                             CreateChickenServiceImpl chickenService,
                             CreateCreateGroupServiceImpl groupService,
                             HistoyServiceImpl hgocService
                                    ) {

        this.chickenService = chickenService;
        this.eggOfChickenService = eggOfChickenService;
        this.groupService = groupService;
        this.hgocService = hgocService;

    }

    @PostMapping("/addEggChicken")
    public String SaveEggOfChicken(@RequestBody AddEggsDTO addEggsDTO) {

        Eggs eggs = Eggs.eggOfChicken(addEggsDTO);

        Chicken chicken = chickenService.findByName(addEggsDTO.getChickenName());


         eggs.setChicken(chicken);
        eggOfChickenService.saveEggOfChicken(eggs);

        History history = new History();

        history.setEggs(eggs);
        history.setChicken(chicken);
        history.setGroup(chicken.getGroup());
        hgocService.saveHgoc(history);



        return "new Egg added";
    }






//TODO Log the group Change in History

    @PostMapping("/addEggGroup")
    public String SaveEggsOfGroup(@RequestBody AddEggsDTO addEggsDTO) {

        Eggs eggs = Eggs.eggOfChicken(addEggsDTO);

       Group group =  groupService.findByName(addEggsDTO.getGroupName());

        eggs.setGroup(group);
        eggOfChickenService.saveEggOfChicken(eggs);


        return "new Egg added";
    }


    @GetMapping("/getAll")
    public List<AddEggsDTO> get(){
        return eggOfChickenService.getAllEggOfChickens()
                .stream()
                .map(eggOfChickenEntity -> AddEggsDTO.eggOfChickenDTO(eggOfChickenEntity))
                .toList();
    }


}
