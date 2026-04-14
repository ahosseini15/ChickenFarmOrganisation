package com.ChickenFarm.ChickenfarmOrganizr.entity;

  import com.ChickenFarm.ChickenfarmOrganizr.data.CreateGroupDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "chicken_group")
@Getter
@Setter
public class Group {

    public static Group group(@NonNull CreateGroupDTO createGroupDTO) {
         Objects.requireNonNull(createGroupDTO);
         Group group = new Group();
         group.setGroupName(createGroupDTO.getGroupName());

         return group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int groupID;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private List<Chicken> chickens = new ArrayList<>();

}
