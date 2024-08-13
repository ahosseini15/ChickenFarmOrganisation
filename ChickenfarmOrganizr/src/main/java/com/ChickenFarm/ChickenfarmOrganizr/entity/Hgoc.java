package com.ChickenFarm.ChickenfarmOrganizr.entity;

import com.ChickenFarm.ChickenfarmOrganizr.data.changing.HgocDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "chicken_history")
@Getter
@Setter
public class Hgoc {

    public static  Hgoc HistorsxEntity(HgocDTO hgocDTO) {

        Objects.requireNonNull(hgocDTO);

        Hgoc hgoc = new Hgoc();

        hgoc.chickenHistoryId = hgocDTO.getChickenHistoryId();
        hgoc.dateOfJoin = hgocDTO.getDateOfJoin();
        hgoc.dateOfLeave = hgocDTO.getDateOfLeave();

        return hgoc;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "chicken_history_id")
    private int chickenHistoryId;


    @ManyToOne
    @JoinColumn( name = "chicken_id")
    private  Chicken chicken;

    @ManyToOne
    @JoinColumn( name = "historicized_group_of_chicken")
    private  Group group;

    @ManyToOne
    @JoinColumn( name = "vaccination")
    private  Vaccination vaccination;

    @ManyToOne
    @JoinColumn( name = "eggs")
    private  Eggs eggs;

    @Column(name = "date_of_join")
    private LocalDate dateOfJoin;

    @Column(name = "date_of_leave")
    private LocalDate dateOfLeave;

}
