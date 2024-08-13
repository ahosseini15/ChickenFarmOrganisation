package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.CChangeService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.CChange;
import com.ChickenFarm.ChickenfarmOrganizr.repository.CChangeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CChangeServiceImpl implements CChangeService {

 CChangeRepo cChangeRepo;

 public CChangeServiceImpl(CChangeRepo cChangeRepo)
 {this.cChangeRepo = cChangeRepo;}


    @Override
 public void saveChickenChange(CChange cChange) {

        cChangeRepo.save(cChange);
    }

    @Override
    public List<CChange> getAllChangedChickens() {

     return cChangeRepo.findAll();
 }

}
