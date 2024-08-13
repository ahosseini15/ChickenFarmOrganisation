package com.ChickenFarm.ChickenfarmOrganizr.data;

import com.ChickenFarm.ChickenfarmOrganizr.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class GroupDTO {

    public static GroupDTO groupDTO(@NonNull Group group) {

        return new GroupDTO(group.getGroupName(), group.getGroupID());

    }
    private String groupName;
    private int groupID;


}
