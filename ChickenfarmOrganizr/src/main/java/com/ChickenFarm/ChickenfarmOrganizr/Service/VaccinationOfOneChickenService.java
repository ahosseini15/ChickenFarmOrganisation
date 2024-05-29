package com.ChickenFarm.ChickenfarmOrganizr.Service;


import com.ChickenFarm.ChickenfarmOrganizr.model.VaccinationOfOneChicken;

import java.util.List;

public interface VaccinationOfOneChickenService {

    void saveVaccinationOfOneChicken(VaccinationOfOneChicken vaccinationOfOneChicken);

    List<VaccinationOfOneChicken> getAllVaccinatedChickens();
}
