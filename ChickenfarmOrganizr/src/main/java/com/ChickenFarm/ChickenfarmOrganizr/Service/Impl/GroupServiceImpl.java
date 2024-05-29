package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.GroupService;
 import com.ChickenFarm.ChickenfarmOrganizr.data.GroupDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import com.ChickenFarm.ChickenfarmOrganizr.repository.ChickenGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.ChickenFarm.ChickenfarmOrganizr.model.Group.group;

@Service
public class GroupServiceImpl implements GroupService {

    public ChickenGroupRepository chickenGroupRepository;

    @Autowired
    public GroupServiceImpl(ChickenGroupRepository chickenGroupRepository){
        this.chickenGroupRepository = chickenGroupRepository;
    }


    @Override
    public void saveGroup(Group group) {
        chickenGroupRepository.save(group);

    }

    public Group findById(int id) {
        return chickenGroupRepository.findById(id).orElse(null);
    }


    public Group findByName(String name) {

        return chickenGroupRepository.findByName(name);
    }


    @Override
    public List<GroupDTO> getAllGroup() {
        return chickenGroupRepository.findAll().stream()
                .map(GroupDTO::groupDTO)
                .toList();
    }


}

