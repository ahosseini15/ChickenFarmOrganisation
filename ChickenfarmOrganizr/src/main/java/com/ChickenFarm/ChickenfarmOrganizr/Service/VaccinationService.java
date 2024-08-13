package com.ChickenFarm.ChickenfarmOrganizr.Service;


import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;

import java.util.List;

public interface VaccinationService {

    void saveVaccinationOfOneChicken(Vaccination vaccination);

    List<Vaccination> getAllVaccinatedChickens();
}
