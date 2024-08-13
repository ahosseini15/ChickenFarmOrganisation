package com.ChickenFarm.ChickenfarmOrganizr.entity;

import com.ChickenFarm.ChickenfarmOrganizr.data.changing.CChangeDTO;
import com.ChickenFarm.ChickenfarmOrganizr.data.ChickenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "chicken_change")
@Entity
@Getter
@Setter
public class CChange {

    public static CChange chickenChange(CChangeDTO cChangeDTO) {


        Objects.requireNonNull(cChangeDTO);

        CChange cChange = new CChange();

        cChange.chickenChangeId = cChangeDTO.getId();
        cChange.dateOfChange = cChangeDTO.getDateOfChange();
        cChange.oldGroup = cChangeDTO.getOldGroup();
        cChange.newGroup = cChangeDTO.getNewGroup();

        return cChange;


    }

    public static CChange newChicken(ChickenDTO chickenDTO) {

        Objects.requireNonNull(chickenDTO);
        CChange cChange = new CChange();
        cChange.newGroup = chickenDTO.getGroupId();
        return cChange;
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
