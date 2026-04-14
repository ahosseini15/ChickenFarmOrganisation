package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.AddVaccinationService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;
import com.ChickenFarm.ChickenfarmOrganizr.repository.AddVaccinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddAddVaccinationServiceImpl implements AddVaccinationService {

    AddVaccinationRepository addVaccinationRepository;

    public AddAddVaccinationServiceImpl(AddVaccinationRepository addVaccinationRepository) {

        this.addVaccinationRepository = addVaccinationRepository;

    }
    @Override
    public void saveVaccinationOfOneChicken(Vaccination vaccination)
    {
        addVaccinationRepository.save(vaccination);
    }


    public Vaccination findById(int Id){

        return addVaccinationRepository.findById(Id).orElse(null);
    }

    public List<Vaccination> findByChickenId(int chickenId, int groupId) {
        return addVaccinationRepository.findByChickenId(chickenId, groupId);
    }

    @Override
    public List<Vaccination> getAllVaccinatedChickens(){ return addVaccinationRepository.findAll();}
}
