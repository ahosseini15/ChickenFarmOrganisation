package com.ChickenFarm.ChickenfarmOrganizr.entity;

import com.ChickenFarm.ChickenfarmOrganizr.data.AddEggsDTO;
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

public static Eggs eggOfChicken(AddEggsDTO addEggsDTO) {
    Objects.requireNonNull(addEggsDTO);

    Eggs eggs = new Eggs();

    eggs.eocId = addEggsDTO.getId();
    eggs.dateOfPutEgg = addEggsDTO.getDateOfPutEgg();
    eggs.size = addEggsDTO.getSize();
    eggs.timeOfPutEgg = addEggsDTO.getTimeOfPutEgg();
    eggs.croud = addEggsDTO.getCroud();

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
