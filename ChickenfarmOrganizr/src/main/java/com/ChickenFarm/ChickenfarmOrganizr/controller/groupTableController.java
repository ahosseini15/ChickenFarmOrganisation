package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.model.groupTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class groupTableController {


    GroupServiceImpl groupService;
    public groupTableController(GroupServiceImpl groupService){

        this.groupService = groupService;

    }

    @PostMapping("/add2")
    public String add(@RequestBody groupTable groupTable) {

groupService.saveGroup(groupTable);

        return "group saved ";
    }


    @GetMapping("/getAll2")
    public List<groupTable> get(){
        return groupService.getAllGroup();
    }

}
