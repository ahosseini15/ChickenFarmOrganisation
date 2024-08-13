package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.GroupService;
 import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    public GroupRepo groupRepo;

    @Autowired
    public GroupServiceImpl(GroupRepo groupRepo){
        this.groupRepo = groupRepo;
    }


    @Override
    public void saveGroup(Group group) {
        groupRepo.save(group);

    }

    public Group findById(int id) {
        return groupRepo.findById(id).orElse(null);
    }


    public Group findByName(String name) {

        return groupRepo.findByName(name);
    }


    @Override
    public List<GroupDTO> getAllGroup() {
        return groupRepo.findAll().stream()
                .map(GroupDTO::groupDTO)
                .toList();
    }


}

