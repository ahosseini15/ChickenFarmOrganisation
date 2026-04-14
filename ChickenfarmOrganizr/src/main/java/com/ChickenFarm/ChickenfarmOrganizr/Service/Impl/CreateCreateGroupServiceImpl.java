package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.CreateGroupService;
 import com.ChickenFarm.ChickenfarmOrganizr.data.CreateGroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.repository.CreateGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateCreateGroupServiceImpl implements CreateGroupService {

    public CreateGroupRepo createGroupRepo;

    @Autowired
    public CreateCreateGroupServiceImpl(CreateGroupRepo createGroupRepo){
        this.createGroupRepo = createGroupRepo;
    }


    @Override
    public void saveGroup(Group group) {
        createGroupRepo.save(group);

    }

    public Group findById(int id) {
        return createGroupRepo.findById(id).orElse(null);
    }


    public Group findByName(String name) {

        return createGroupRepo.findByName(name);
    }


    @Override
    public List<CreateGroupDTO> getAllGroup() {
        return createGroupRepo.findAll().stream()
                .map(CreateGroupDTO::groupDTO)
                .toList();
    }


}

