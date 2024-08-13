package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Chicken;

import java.util.List;

public interface ChickenService {
    void saveChicken(Chicken chicken);
    List<Chicken> getAllChickens();

    public Chicken findByName(String name);
}
