package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.EggsOfGroupService;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggsOfGroup;
import com.ChickenFarm.ChickenfarmOrganizr.repository.EggsOfGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EggsOfGroupServiceImpl  implements EggsOfGroupService {
    EggsOfGroupRepository eggsOfGroupRepository;
    public EggsOfGroupServiceImpl(EggsOfGroupRepository eggsOfGroupRepository){
        this.eggsOfGroupRepository = eggsOfGroupRepository;
    }
    @Override
    public void saveEggsOfGroup(EggsOfGroup eggsOfGroup){eggsOfGroupRepository.save(eggsOfGroup); }

    @Override
    public List<EggsOfGroup> getAllEggsOfGroup() {
        return eggsOfGroupRepository.findAll();
    }

}
