package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;


import com.ChickenFarm.ChickenfarmOrganizr.Service.AddEggsService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Eggs;
import com.ChickenFarm.ChickenfarmOrganizr.repository.AddEggsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddAddEggsServiceImpl implements AddEggsService {


    AddEggsRepo eggsRepo;
    public AddAddEggsServiceImpl(AddEggsRepo eggsRepo) {
        this.eggsRepo = eggsRepo;
    }



    public Eggs eggfindById(int id) {

        return eggsRepo.findById(id).orElse(null);
    }
    @Override
    public void saveEggOfChicken(Eggs eggs) {
        eggsRepo.save(eggs);
    }

    @Override
    public List<Eggs> getAllEggsOfChicken() {
        return eggsRepo.findAll() ;
    }
    public List<Eggs> getAllEggOfChickens(){return eggsRepo.findAll();}
}
