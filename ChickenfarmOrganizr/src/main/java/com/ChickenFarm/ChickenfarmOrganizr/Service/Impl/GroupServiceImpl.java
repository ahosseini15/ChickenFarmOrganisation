package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.groupService;
import com.ChickenFarm.ChickenfarmOrganizr.model.groupTable;
import com.ChickenFarm.ChickenfarmOrganizr.repository.groupTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements groupService {





    public groupTableRepository groupTableRepository;

    public GroupServiceImpl(groupTableRepository groupTableRepository){
        this.groupTableRepository = groupTableRepository;
    }


    @Override
    public groupTable saveGroup(groupTable groupTable) {
        return groupTableRepository.save(groupTable);
    }

    @Override
    public List<groupTable> getAllGroup() {
        return groupTableRepository.findAll();
    }
}

