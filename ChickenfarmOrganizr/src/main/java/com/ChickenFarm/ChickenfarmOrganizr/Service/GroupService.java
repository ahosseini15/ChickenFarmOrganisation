package com.ChickenFarm.ChickenfarmOrganizr.Service;

 import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;

import java.util.List;

public interface GroupService {


    void saveGroup (Group group);



   List<GroupDTO> getAllGroup();

}
