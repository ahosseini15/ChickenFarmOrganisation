package com.ChickenFarm.ChickenfarmOrganizr.controller;


import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
 // import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.slf4j.LoggerFactory.getLogger;


@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupTableController {

    private static final Logger LOGGER = getLogger(GroupTableController.class);
    GroupServiceImpl groupService;
    public GroupTableController(GroupServiceImpl groupService){

        this.groupService = groupService;

    }

    @PostMapping("/add2")
    public void add(@RequestBody Group group) {

        groupService.saveGroup(group);
        LOGGER.info("Data Saved");

    }




    @GetMapping("/getAll2")
    public List<GroupDTO> get(){
        return groupService.getAllGroup();
    }

}


