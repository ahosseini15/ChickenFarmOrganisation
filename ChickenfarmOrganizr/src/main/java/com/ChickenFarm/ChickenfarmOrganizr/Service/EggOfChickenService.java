package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.data.EggOfChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import com.ChickenFarm.ChickenfarmOrganizr.repository.EggOfChickenRepository;

import java.util.List;

public interface EggOfChickenService {

    void saveEggOfChicken(EggOfChicken eggOfChicken);

    List<EggOfChicken> getAllEggsOfChicken();


}
