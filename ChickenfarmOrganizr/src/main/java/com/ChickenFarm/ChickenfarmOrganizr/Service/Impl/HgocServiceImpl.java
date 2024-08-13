package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.HgocService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.Hgoc;
import com.ChickenFarm.ChickenfarmOrganizr.repository.HgocRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HgocServiceImpl implements HgocService {


    final HgocRepo hgocRepo;

    public HgocServiceImpl(HgocRepo hgocRepo) { this.hgocRepo = hgocRepo;}

    @Override
    public void saveHgoc(Hgoc hgoc) {

        hgocRepo.save(hgoc);
    }

    public  Hgoc findHistory(int groupId, int chickenId) {

        return hgocRepo.findHistory(groupId, chickenId);
    }


    @Override
    public List<Hgoc> getAllHgoc() {
        return hgocRepo.findAll();
    }
}
