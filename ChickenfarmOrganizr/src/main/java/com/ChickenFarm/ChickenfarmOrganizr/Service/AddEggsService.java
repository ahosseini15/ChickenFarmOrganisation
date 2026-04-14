package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;

import java.util.List;

public interface AddEggsService {

    void saveEggOfChicken(Eggs eggs);

    List<Eggs> getAllEggsOfChicken();


}
