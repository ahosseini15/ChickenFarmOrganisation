package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.ChickenService;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.repository.ChickenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChickenServiceImpl implements ChickenService {

    final ChickenRepository chickenRepository;

    public ChickenServiceImpl(ChickenRepository chickenRepository){
        this.chickenRepository = chickenRepository;
    }

    public Chicken findByName(String name){
        
        return chickenRepository.findByName(name);
    }
    
    @Override
    public void saveChicken(Chicken chicken) {

        chickenRepository.save(chicken);

    }


    public void updateChicken(Chicken chickenToUpdate) {

        chickenRepository.save(chickenToUpdate);
    }

    @Override
    public List<Chicken> getAllChickens() {
        return chickenRepository.findAll();
    }
}
