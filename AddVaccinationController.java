package com.ChickenFarm.ChickenfarmOrganizr.controller;

import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateChickenServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.CreateCreateGroupServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.HistoyServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.Service.Impl.AddAddVaccinationServiceImpl;
import com.ChickenFarm.ChickenfarmOrganizr.data.AddVaccinationsDTO;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import com.ChickenFarm.ChickenfarmOrganizr.entity.History;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Vaccination;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinations")
@CrossOrigin
public class AddVaccinationController {
    final AddAddVaccinationServiceImpl vaccinationOfOneChickenService;
    final CreateChickenServiceImpl chickenService;
    final CreateCreateGroupServiceImpl groupService;

    final HistoyServiceImpl hgocService;


    public AddVaccinationController(AddAddVaccinationServiceImpl vaccinationOfOneChickenService,
                                    CreateChickenServiceImpl chickenService,
                                    CreateCreateGroupServiceImpl groupService,
                                    HistoyServiceImpl hgocService
                                                ) {

        this.chickenService = chickenService;
        this.vaccinationOfOneChickenService = vaccinationOfOneChickenService;
        this.groupService = groupService;
        this.hgocService = hgocService;

    }

    @PostMapping("/addOneVaccination")
    public String SaveVaccinationOfOneChicken(@RequestBody AddVaccinationsDTO addVaccinationsDTO) throws Exception {
        Vaccination vaccination = Vaccination.vaccinationOfOneChicken(addVaccinationsDTO);

        Chicken chicken = chickenService.findByName(addVaccinationsDTO.getChickenName());

        Group group = groupService.findById(chicken.getGroup().getGroupID());
        vaccination.setChicken(chicken);
        vaccination.setGroup(group);

        vaccinationOfOneChickenService.saveVaccinationOfOneChicken(vaccination);

        History history = new History();

        history.setChicken(chicken);
        history.setGroup(chicken.getGroup());
        history.setVaccination(vaccination);

        hgocService.saveHgoc(history);

        return "new vaccination added";

    }


    //TODO Add Group History Log
    @PostMapping("/addVaccinationGroup")
    public String SaveVaccinationOfGroup(@RequestBody AddVaccinationsDTO addVaccinationsDTO) throws Exception {
        Vaccination vaccination = Vaccination.vaccinationOfOneChicken(addVaccinationsDTO);

        Group group = groupService.findByName(addVaccinationsDTO.getGroupName());

        vaccination.setGroup(group);

        vaccinationOfOneChickenService.saveVaccinationOfOneChicken(vaccination);


        return "new vaccination added";

    }


    @GetMapping("/getAll")
    public List<AddVaccinationsDTO> get(){
        return vaccinationOfOneChickenService.getAllVaccinatedChickens()
                .stream()
                .map(vaccinationOfOneChickenEntity -> AddVaccinationsDTO.vaccinationOfOneChickenDTO(vaccinationOfOneChickenEntity))
                .toList();
    }

}
