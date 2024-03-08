package com.ChickenFarm.ChickenfarmOrganizr.Service;

import com.ChickenFarm.ChickenfarmOrganizr.model.groupTable;

import java.util.List;

public interface groupService {


    public groupTable saveGroup (groupTable groupTable);
    public List<groupTable> getAllGroup();

}
