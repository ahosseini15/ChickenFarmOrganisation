package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.EggOfChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.ChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.EggOfChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggOfChicken")
@CrossOrigin
public class EggOfChickenController {

    final EggOfChickenServiceImpl eggOfChickenService;
    final ChickenServiceImpl chickenService;

    public EggOfChickenController(EggOfChickenServiceImpl eggOfChickenService,
                                  ChickenServiceImpl chickenService
                                    ) {
        this.chickenService = chickenService;
        this.eggOfChickenService = eggOfChickenService;

    }
    @PostMapping("/add")
    public String SaveEggOfChicken(@RequestBody EggOfChickenDTO eggOfChickenDTO) {

        EggOfChicken eggOfChicken = EggOfChicken.eggOfChicken(eggOfChickenDTO);

        Chicken chicken = chickenService.findByName(eggOfChickenDTO.getChickenName());


         eggOfChicken.setChicken(chicken);
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
