package com.ChickenFarm.ChickenfarmOrganizr.model;

import com.ChickenFarm.ChickenfarmOrganizr.data.EggOfChickenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Table(name = "egg_of_chicken")
@Entity
@Getter
@Setter
public class EggOfChicken {

public static EggOfChicken eggOfChicken(EggOfChickenDTO eggOfChickenDTO) {
    Objects.requireNonNull(eggOfChickenDTO);

    EggOfChicken eggOfChicken = new EggOfChicken();

    eggOfChicken.eocId = eggOfChickenDTO.getId();
    eggOfChicken.dateOfPutEgg = eggOfChickenDTO.getDateOfPutEgg();
    eggOfChicken.size = eggOfChickenDTO.getSize();
    eggOfChicken.timeOfPutEgg = eggOfChickenDTO.getTimeOfPutEgg();
    eggOfChicken.croud = eggOfChickenDTO.getCroud();

    return  eggOfChicken;
}


    @Id
    @Column(name = "eoc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eocId;


    @ManyToOne
    @JoinColumn(name = "chicken_id")
    private Chicken chicken;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "date_of_put_egg")
    private String dateOfPutEgg;

    @Column(name = "time_of_put_egg")
    private String timeOfPutEgg;

    @Column(name = "size")
    private String size;

    @Column(name = "croud")
    private String croud;
}
