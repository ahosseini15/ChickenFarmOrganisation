package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;


import com.ChickenFarm.ChickenfarmOrganizr.Service.EggOfChickenService;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggOfChicken;
import com.ChickenFarm.ChickenfarmOrganizr.repository.EggOfChickenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EggOfChickenServiceImpl implements EggOfChickenService {


    EggOfChickenRepository eggOfChickenRepository;
    public EggOfChickenServiceImpl(EggOfChickenRepository eggOfChickenRepository) {
        this.eggOfChickenRepository = eggOfChickenRepository;
    }


    @Override
    public void saveEggOfChicken(EggOfChicken eggOfChicken) {
        eggOfChickenRepository.save(eggOfChicken);
    }

    @Override
    public List<EggOfChicken> getAllEggsOfChicken() {
        return eggOfChickenRepository.findAll() ;
    }
    public List<EggOfChicken> getAllEggOfChickens(){return eggOfChickenRepository.findAll();}
}
