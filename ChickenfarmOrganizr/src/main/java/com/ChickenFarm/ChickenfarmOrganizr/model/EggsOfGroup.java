package com.ChickenFarm.ChickenfarmOrganizr.model;


import com.ChickenFarm.ChickenfarmOrganizr.data.EggsOfGroupDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Table(name = "eggs_of_group")
@Entity
@Getter
@Setter
public class EggsOfGroup {


    public  static EggsOfGroup eggsOfGroup(EggsOfGroupDTO eggsOfGroupDTO) {
        Objects.requireNonNull(eggsOfGroupDTO);

        EggsOfGroup eggsOfGroup = new EggsOfGroup();

        eggsOfGroup.eggsOfGroupId = eggsOfGroupDTO.getId();
        eggsOfGroup.dateOfCollectEggs = eggsOfGroupDTO.getDateOfCollectEggs();
        eggsOfGroup.timeOfCollectEggs = eggsOfGroupDTO.getTimeOfCollectEggs();
        eggsOfGroup.croud = eggsOfGroupDTO.getCroud();

        return eggsOfGroup;

    }
        @Id
        @Column(name = "eggs_of_group_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int eggsOfGroupId;

        @ManyToOne
        @JoinColumn(name = "group_id")
        private Group group;

        @Column(name = "date_of_collect_eggs")
        private String dateOfCollectEggs;

        @Column(name = "time_of_collect_eggs")
        private String timeOfCollectEggs;

        @Column(name = "croud")
        private String croud;





}
