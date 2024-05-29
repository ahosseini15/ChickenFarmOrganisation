package com.ChickenFarm.ChickenfarmOrganizr.Service;
import com.ChickenFarm.ChickenfarmOrganizr.model.EggsOfGroup;
import java.util.List;

public interface EggsOfGroupService {
    void saveEggsOfGroup(EggsOfGroup eggsOfGroup);

    List<EggsOfGroup> getAllEggsOfGroup();

}
