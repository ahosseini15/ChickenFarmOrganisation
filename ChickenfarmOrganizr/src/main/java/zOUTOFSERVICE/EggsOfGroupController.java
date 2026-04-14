package zOUTOFSERVICE;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateCreateGroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggsOfGroup")
@CrossOrigin
public class EggsOfGroupController {
final EggsOfGroupServiceImpl eggsOfGroupService;

final CreateCreateGroupServiceImpl groupService;


    public EggsOfGroupController(EggsOfGroupServiceImpl eggsOfGroupService,
                                  CreateCreateGroupServiceImpl groupService
                                )
    {
        this.groupService = groupService;
        this.eggsOfGroupService = eggsOfGroupService;
    }

@PostMapping("/add")
public String  SaveEggsOfGroup(@RequestBody EggsOfGroupDTO eggsOfGroupDTO) throws Exception {

    EggsOfGroup eggsOfGroup = EggsOfGroup.eggsOfGroup(eggsOfGroupDTO);

    Group group = groupService.findByName(eggsOfGroupDTO.getGroupName());



    eggsOfGroup.setGroup(group);
    eggsOfGroupService.saveEggsOfGroup(eggsOfGroup);

    return "new Eggs added";

    }


    @GetMapping("/getAll")
    public List<EggsOfGroupDTO> get(){
        return eggsOfGroupService.getAllEggsOfGroup()
                .stream()
                .map(eggsOfGroupEntity -> EggsOfGroupDTO.eggOfGroupDTO(eggsOfGroupEntity))
                .toList();
    }

}














