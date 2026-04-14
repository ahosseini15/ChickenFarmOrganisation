package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.entity.GroupOfChickenChange;

import java.util.List;

public interface GroupOfChickenChangeingService {
    void saveChickenChange(GroupOfChickenChange groupOfChickenChange);
    List<GroupOfChickenChange> getAllChangedChickens();
}
