package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;

import java.util.List;

public interface EggsService {

    void saveEggOfChicken(Eggs eggs);

    List<Eggs> getAllEggsOfChicken();


}
