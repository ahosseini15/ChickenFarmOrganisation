package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CreateGroupDTO {

    public static CreateGroupDTO groupDTO(@NonNull Group group) {

        return new CreateGroupDTO(group.getGroupName(), group.getGroupID());

    }
    private String groupName;
    private int groupID;


}
