package zOUTOFSERVICE;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EggsOfGroupServiceImpl  implements EggsOfGroupService {
    EggsOfGroupRepository eggsOfGroupRepository;
    public EggsOfGroupServiceImpl(EggsOfGroupRepository eggsOfGroupRepository){
        this.eggsOfGroupRepository = eggsOfGroupRepository;
    }
    @Override
    public void saveEggsOfGroup(EggsOfGroup eggsOfGroup){eggsOfGroupRepository.save(eggsOfGroup); }

    @Override
    public List<EggsOfGroup> getAllEggsOfGroup() {
        return eggsOfGroupRepository.findAll();
    }

}
