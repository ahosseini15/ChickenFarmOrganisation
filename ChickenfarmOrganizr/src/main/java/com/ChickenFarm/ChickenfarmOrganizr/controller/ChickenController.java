package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.model.chicken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken")
@CrossOrigin
public class ChickenController {

    ChickenServiceImpl chickenService;

    public ChickenController(ChickenServiceImpl chickenService) {
        this.chickenService = chickenService;
    }

    @PostMapping("/add")
    public String add(@RequestBody chicken chicken) {

        chickenService.saveChicken(chicken);


        return "new chicken is added";

    }





    @GetMapping("/getAll")
    public List<chicken> get(){

         return chickenService.getAllChickens();


    }
}
