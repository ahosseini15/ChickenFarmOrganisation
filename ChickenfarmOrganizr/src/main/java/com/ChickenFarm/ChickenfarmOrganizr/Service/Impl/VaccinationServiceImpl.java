package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.VaccinationService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;
import com.ChickenFarm.ChickenfarmOrganizr.repository.VaccinationOfOneChickenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationServiceImpl implements VaccinationService {

    VaccinationOfOneChickenRepository vaccinationOfOneChickenRepository;

    public VaccinationServiceImpl(VaccinationOfOneChickenRepository vaccinationOfOneChickenRepository) {

        this.vaccinationOfOneChickenRepository = vaccinationOfOneChickenRepository;

    }
    @Override
    public void saveVaccinationOfOneChicken(Vaccination vaccination)
    {
        vaccinationOfOneChickenRepository.save(vaccination);
    }


    public Vaccination findById(int Id){

        return vaccinationOfOneChickenRepository.findById(Id).orElse(null);
    }

    public List<Vaccination> findByChickenId(int chickenId, int groupId) {
        return vaccinationOfOneChickenRepository.findByChickenId(chickenId, groupId);
    }

    @Override
    public List<Vaccination> getAllVaccinatedChickens(){ return vaccinationOfOneChickenRepository.findAll();}
}
