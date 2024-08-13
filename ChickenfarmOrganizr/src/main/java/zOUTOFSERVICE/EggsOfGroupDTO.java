package zOUTOFSERVICE;


import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class EggsOfGroupDTO {

private int id;
private String timeOfCollectEggs;
private String dateOfCollectEggs;
private String croud;
private String groupName;

public static EggsOfGroupDTO eggOfGroupDTO(@NonNull EggsOfGroup eggsOfGroup) {


    Group group = eggsOfGroup.getGroup();

    return new EggsOfGroupDTO(
            eggsOfGroup.getEggsOfGroupId(),
            eggsOfGroup.getDateOfCollectEggs(),
            eggsOfGroup.getTimeOfCollectEggs(),
            eggsOfGroup.getCroud(),
            group.getGroupName()
    );

}

}
