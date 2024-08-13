package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.ChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.GroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.HgocServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.VaccinationServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.VaccinationsDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Hgoc;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinations")
@CrossOrigin
public class VaccinationController {
    final VaccinationServiceImpl vaccinationOfOneChickenService;
    final ChickenServiceImpl chickenService;
    final GroupServiceImpl groupService;

    final HgocServiceImpl hgocService;


    public VaccinationController(VaccinationServiceImpl vaccinationOfOneChickenService,
                                 ChickenServiceImpl chickenService,
                                 GroupServiceImpl groupService,
                                 HgocServiceImpl hgocService
                                                ) {

        this.chickenService = chickenService;
        this.vaccinationOfOneChickenService = vaccinationOfOneChickenService;
        this.groupService = groupService;
        this.hgocService = hgocService;

    }

    @PostMapping("/addOneVaccination")
    public String SaveVaccinationOfOneChicken(@RequestBody VaccinationsDTO vaccinationsDTO) throws Exception {
        Vaccination vaccination = Vaccination.vaccinationOfOneChicken(vaccinationsDTO);

        Chicken chicken = chickenService.findByName(vaccinationsDTO.getChickenName());

        Group group = groupService.findById(chicken.getGroup().getGroupID());
        vaccination.setChicken(chicken);
        vaccination.setGroup(group);

        vaccinationOfOneChickenService.saveVaccinationOfOneChicken(vaccination);

        Hgoc hgoc = new Hgoc();

        hgoc.setChicken(chicken);
        hgoc.setGroup(chicken.getGroup());
        hgoc.setVaccination(vaccination);

        hgocService.saveHgoc(hgoc);

        return "new vaccination added";

    }

    @PostMapping("/addVaccinationGroup")
    public String SaveVaccinationOfGroup(@RequestBody VaccinationsDTO vaccinationsDTO) throws Exception {
        Vaccination vaccination = Vaccination.vaccinationOfOneChicken(vaccinationsDTO);

        Group group = groupService.findByName(vaccinationsDTO.getGroupName());

        vaccination.setGroup(group);

        vaccinationOfOneChickenService.saveVaccinationOfOneChicken(vaccination);


        return "new vaccination added";

    }
    @GetMapping("/getAll")
    public List<VaccinationsDTO> get(){
        return vaccinationOfOneChickenService.getAllVaccinatedChickens()
                .stream()
                .map(vaccinationOfOneChickenEntity -> VaccinationsDTO.vaccinationOfOneChickenDTO(vaccinationOfOneChickenEntity))
                .toList();
    }

}
