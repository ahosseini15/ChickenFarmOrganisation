package com.ChickenFarm.ChickenfarmOrganizr.entity;

import com.ChickenFarm.ChickenfarmOrganizr.data.EggsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Table(name = "egg_of_chicken")
@Entity
@Getter
@Setter
public class Eggs {

public static Eggs eggOfChicken(EggsDTO eggsDTO) {
    Objects.requireNonNull(eggsDTO);

    Eggs eggs = new Eggs();

    eggs.eocId = eggsDTO.getId();
    eggs.dateOfPutEgg = eggsDTO.getDateOfPutEgg();
    eggs.size = eggsDTO.getSize();
    eggs.timeOfPutEgg = eggsDTO.getTimeOfPutEgg();
    eggs.croud = eggsDTO.getCroud();

    return eggs;
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
    private LocalDate dateOfPutEgg;

    @Column(name = "time_of_put_egg")
    private LocalTime timeOfPutEgg;

    @Column(name = "size")
    private String size;

    @Column(name = "croud")
    private Integer croud;
}
