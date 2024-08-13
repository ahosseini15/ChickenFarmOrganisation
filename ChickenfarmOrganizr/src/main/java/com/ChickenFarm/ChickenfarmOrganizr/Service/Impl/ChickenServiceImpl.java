package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.ChickenService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.repository.ChickenRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChickenServiceImpl implements ChickenService {

    final ChickenRepo chickenRepo;

    public ChickenServiceImpl(ChickenRepo chickenRepo){
        this.chickenRepo = chickenRepo;
    }

    public Chicken findByName(String name){
        
        return chickenRepo.findByName(name);
    }


    public Optional<Chicken> findById(int id){

        return chickenRepo.findById(id);
    }



    @Override
    public void saveChicken(Chicken chicken) {

        chickenRepo.save(chicken);

    }


    public void updateChicken(Chicken chickenToUpdate) {

        chickenRepo.save(chickenToUpdate);
    }

    @Override
    public List<Chicken> getAllChickens() {
        return chickenRepo.findAll();
    }
}
