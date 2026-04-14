package com.ChickenFarm.ChickenfarmOrganizr.entity;

import com.ChickenFarm.ChickenfarmOrganizr.data.historyAndGroupOfChickenChanging.GroupOfChickenChangingDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.CreateChickenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "chicken_change")
@Entity
@Getter
@Setter
public class GroupOfChickenChange {

    public static GroupOfChickenChange chickenChange(GroupOfChickenChangingDTO groupOfChickenChangingDTO) {


        Objects.requireNonNull(groupOfChickenChangingDTO);

        GroupOfChickenChange groupOfChickenChange = new GroupOfChickenChange();

        groupOfChickenChange.chickenChangeId = groupOfChickenChangingDTO.getId();
        groupOfChickenChange.dateOfChange = groupOfChickenChangingDTO.getDateOfChange();
        groupOfChickenChange.oldGroup = groupOfChickenChangingDTO.getOldGroup();
        groupOfChickenChange.newGroup = groupOfChickenChangingDTO.getNewGroup();

        return groupOfChickenChange;


    }

    public static GroupOfChickenChange newChicken(CreateChickenDTO createChickenDTO) {

        Objects.requireNonNull(createChickenDTO);
        GroupOfChickenChange groupOfChickenChange = new GroupOfChickenChange();
        groupOfChickenChange.newGroup = createChickenDTO.getGroupId();
        return groupOfChickenChange;
    }



    @Id
    @Column(name = "chicken_change_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chickenChangeId;


    @ManyToOne
    @JoinColumn(name = "chicken_id")
    Chicken chicken;

    @Column(name = "old_group")
    private Integer oldGroup;

    @Column(name = "new_group")
    private Integer newGroup;

    @Column(name = "date_of_change")
    private LocalDate dateOfChange;










}
