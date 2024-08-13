package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.entity.CChange;

import java.util.List;

public interface CChangeService {
    void saveChickenChange(CChange cChange);
    List<CChange> getAllChangedChickens();
}
