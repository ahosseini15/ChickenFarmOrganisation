package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.VaccinationOfOneChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.VaccinationOfOneChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.VaccinationOfOneChicken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinationOfOneChicken")
@CrossOrigin
public class VaccinationOfOneChickenController {
    final VaccinationOfOneChickenServiceImpl vaccinationOfOneChickenService;

    final ChickenServiceImpl chickenService;


    public VaccinationOfOneChickenController(VaccinationOfOneChickenServiceImpl vaccinationOfOneChickenService,
                                             ChickenServiceImpl chickenService
                                                ) {

        this.chickenService = chickenService;
        this.vaccinationOfOneChickenService = vaccinationOfOneChickenService;

    }

    @PostMapping("/add")
    public String SaveVaccinationOfOneChicken(@RequestBody VaccinationOfOneChickenDTO vaccinationOfOneChickenDTO) throws Exception {
        VaccinationOfOneChicken vaccinationOfOneChicken = VaccinationOfOneChicken.vaccinationOfOneChicken(vaccinationOfOneChickenDTO);

        Chicken chicken = chickenService.findByName(vaccinationOfOneChickenDTO.getChickenName());

        vaccinationOfOneChicken.setChicken(chicken);

        vaccinationOfOneChickenService.saveVaccinationOfOneChicken(vaccinationOfOneChicken);
        return "new vaccination added";

    }

    @GetMapping("/getAll")
    public List<VaccinationOfOneChickenDTO> get(){
        return vaccinationOfOneChickenService.getAllVaccinatedChickens()
                .stream()
                .map(vaccinationOfOneChickenEntity -> VaccinationOfOneChickenDTO.vaccinationOfOneChickenDTO(vaccinationOfOneChickenEntity))
                .toList();
    }

}
