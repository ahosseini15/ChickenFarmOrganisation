package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.GroupOfChickenChangeingService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.GroupOfChickenChange;
import com.ChickenFarm.ChickenfarmOrganizr.repository.GroupOfChickenChangingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupOfChickenChangingServiceImpl implements GroupOfChickenChangeingService {

 GroupOfChickenChangingRepo groupOfChickenChangingRepo;

 public GroupOfChickenChangingServiceImpl(GroupOfChickenChangingRepo groupOfChickenChangingRepo)
 {this.groupOfChickenChangingRepo = groupOfChickenChangingRepo;}


    @Override
 public void saveChickenChange(GroupOfChickenChange groupOfChickenChange) {

        groupOfChickenChangingRepo.save(groupOfChickenChange);
    }

    @Override
    public List<GroupOfChickenChange> getAllChangedChickens() {

     return groupOfChickenChangingRepo.findAll();
 }

}
