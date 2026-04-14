package com.ChickenFarm.ChickenfarmOrganizr.Service.Impl;

import com.ChickenFarm.ChickenfarmOrganizr.Service.HistoryService;
import com.ChickenFarm.ChickenfarmOrganizr.entity.History;
import com.ChickenFarm.ChickenfarmOrganizr.repository.HistoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoyServiceImpl implements HistoryService {


    final HistoryRepo historyRepo;

    public HistoyServiceImpl(HistoryRepo historyRepo) { this.historyRepo = historyRepo;}

    @Override
    public void saveHgoc(History history) {

        historyRepo.save(history);
    }

    public History findHistory(int groupId, int chickenId) {

        return historyRepo.findHistory(groupId, chickenId);
    }


    @Override
    public List<History> getAllHgoc() {
        return historyRepo.findAll();
    }
}
