package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.CreateChickenService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.repository.AddChickenRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateChickenServiceImpl implements CreateChickenService {

    final AddChickenRepo addChickenRepo;

    public CreateChickenServiceImpl(AddChickenRepo addChickenRepo){
        this.addChickenRepo = addChickenRepo;
    }

    public Chicken findByName(String name){
        
        return addChickenRepo.findByName(name);
    }


    public Optional<Chicken> findById(int id){

        return addChickenRepo.findById(id);
    }



    @Override
    public void saveChicken(Chicken chicken) {

        addChickenRepo.save(chicken);

    }


    public void updateChicken(Chicken chickenToUpdate) {

        addChickenRepo.save(chickenToUpdate);
    }

    @Override
    public List<Chicken> getAllChickens() {
        return addChickenRepo.findAll();
    }
}
