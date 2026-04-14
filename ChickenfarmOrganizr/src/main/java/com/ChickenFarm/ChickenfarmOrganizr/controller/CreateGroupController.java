package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateCreateGroupServiceImpl;
 // import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.CreateGroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.slf4j.LoggerFactory.getLogger;


@RestController
@RequestMapping("/group")
@CrossOrigin
public class CreateGroupController {

    private static final Logger LOGGER = getLogger(CreateGroupController.class);
    CreateCreateGroupServiceImpl groupService;
    public CreateGroupController(CreateCreateGroupServiceImpl groupService){

        this.groupService = groupService;

    }


    //TODO Add Creating Group log to History
    @PostMapping("/add2")
    public void add(@RequestBody Group group) {

        groupService.saveGroup(group);
        LOGGER.info("Data Saved");

    }




    @GetMapping("/getAll2")
    public List<CreateGroupDTO> get(){
        return groupService.getAllGroup();
    }

}


