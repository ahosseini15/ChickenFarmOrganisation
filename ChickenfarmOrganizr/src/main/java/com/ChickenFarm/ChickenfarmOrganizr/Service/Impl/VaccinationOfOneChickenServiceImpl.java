package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.VaccinationOfOneChickenService;
import com.ChickenFarm.ChickenfarmOrganizr.model.VaccinationOfOneChicken;
import com.ChickenFarm.ChickenfarmOrganizr.repository.VaccinationOfOneChickenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationOfOneChickenServiceImpl implements VaccinationOfOneChickenService {

    VaccinationOfOneChickenRepository vaccinationOfOneChickenRepository;

    public  VaccinationOfOneChickenServiceImpl(VaccinationOfOneChickenRepository vaccinationOfOneChickenRepository) {

        this.vaccinationOfOneChickenRepository = vaccinationOfOneChickenRepository;

    }
    @Override
    public void saveVaccinationOfOneChicken(VaccinationOfOneChicken vaccinationOfOneChicken)
    {
        vaccinationOfOneChickenRepository.save(vaccinationOfOneChicken);
    }

    @Override
    public List<VaccinationOfOneChicken> getAllVaccinatedChickens(){ return vaccinationOfOneChickenRepository.findAll();}
}
