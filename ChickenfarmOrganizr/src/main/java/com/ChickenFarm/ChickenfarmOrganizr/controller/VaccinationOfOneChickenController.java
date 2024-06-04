package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.VaccinationOfOneChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.VaccinationOfOneChickenDTO;
import com.ChickenFarm.ChickenfarmOrganizr.model.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.model.Group;
import com.ChickenFarm.ChickenfarmOrganizr.model.VaccinationOfOneChicken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinationOfOneChicken")
@CrossOrigin
public class VaccinationOfOneChickenController {
    final VaccinationOfOneChickenServiceImpl vaccinationOfOneChickenService;

    final ChickenServiceImpl chickenService;
    final GroupServiceImpl groupService;


    public VaccinationOfOneChickenController(VaccinationOfOneChickenServiceImpl vaccinationOfOneChickenService,
                                             ChickenServiceImpl chickenService,
                                             GroupServiceImpl groupService
                                                ) {

        this.chickenService = chickenService;
        this.vaccinationOfOneChickenService = vaccinationOfOneChickenService;
        this.groupService = groupService;

    }

    @PostMapping("/addOneVaccination")
    public String SaveVaccinationOfOneChicken(@RequestBody VaccinationOfOneChickenDTO vaccinationOfOneChickenDTO) throws Exception {
        VaccinationOfOneChicken vaccinationOfOneChicken = VaccinationOfOneChicken.vaccinationOfOneChicken(vaccinationOfOneChickenDTO);

        Chicken chicken = chickenService.findByName(vaccinationOfOneChickenDTO.getChickenName());

        vaccinationOfOneChicken.setChicken(chicken);

        vaccinationOfOneChickenService.saveVaccinationOfOneChicken(vaccinationOfOneChicken);
        return "new vaccination added";

    }

    @PostMapping("/addVaccinationGroup")
    public String SaveVaccinationOfGroup(@RequestBody VaccinationOfOneChickenDTO vaccinationOfOneChickenDTO) throws Exception {
        VaccinationOfOneChicken vaccinationOfOneChicken = VaccinationOfOneChicken.vaccinationOfOneChicken(vaccinationOfOneChickenDTO);

        Group group = groupService.findByName(vaccinationOfOneChickenDTO.getGroupName());

        vaccinationOfOneChicken.setGroup(group);

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
