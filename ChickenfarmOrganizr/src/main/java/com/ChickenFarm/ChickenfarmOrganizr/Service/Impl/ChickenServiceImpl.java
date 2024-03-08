package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.ChickenService;
import com.ChickenFarm.ChickenfarmOrganizr.model.chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.groupTable;
import com.ChickenFarm.ChickenfarmOrganizr.repository.ChickenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChickenServiceImpl implements ChickenService {

     ChickenRepository chickenRepository;
             groupTable groupTable;

    public ChickenServiceImpl(ChickenRepository chickenRepository, groupTable groupTable){
        this.chickenRepository = chickenRepository;
        this.groupTable = groupTable;

    }


    @Override
    public chicken saveChicken(chicken chicken) {

        chicken.setGroup(groupTable);
        return chickenRepository.save(chicken);

    }

    @Override
    public List<chicken> getAllChickens() {
        return chickenRepository.findAll();
    }
}
