package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.model.chicken;

import java.util.List;

public interface ChickenService {
    public chicken saveChicken(chicken student);
    public List<chicken> getAllChickens();
}
