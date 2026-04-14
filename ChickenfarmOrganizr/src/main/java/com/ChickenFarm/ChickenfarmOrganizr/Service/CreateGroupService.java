package com.ChickenFarm.ChickenfarmOrganizr.Service;

 import com.ChickenFarm.ChickenfarmOrganizr.data.CreateGroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;

import java.util.List;

public interface CreateGroupService {


    void saveGroup (Group group);



   List<CreateGroupDTO> getAllGroup();

}
