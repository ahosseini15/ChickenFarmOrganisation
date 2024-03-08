package com.ChickenFarm.ChickenfarmOrganizr.model;

import jakarta.persistence.*;

@Table(name = "chicken")
@Entity
public class chicken {

    @Id
    @Column(name = "chickenid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chickenid;




    public groupTable getGroup() {
        return groupTable;
    }

    public void setGroup(groupTable groupTable) {
        this.groupTable = groupTable;
    }



    @ManyToOne
    @JoinColumn(name = "groupid", nullable = false)
    private groupTable groupTable;


    private String chickenname;
    private String chickengender;
    private String chickenbirthdate;
    private String chickenrace;

    public int getChickenid() {
        return chickenid;
    }
    public void setChickenid(int chickenid) {
        this.chickenid = chickenid;
    }

    public String getChickenname() {
        return chickenname;
    }

    public void setChickenname(String chickenname) {
        this.chickenname = chickenname;
    }

    public String getChickengender() {
        return chickengender;
    }

    public void setChickengender(String chickengender) {
        this.chickengender = chickengender;
    }

    public String getChickenbirthdate() {
        return chickenbirthdate;
    }

    public void setChickenbirthdate(String chickenbirthdate) {
        this.chickenbirthdate = chickenbirthdate;
    }

    public String getChickenrace() {
        return chickenrace;
    }

    public void setChickenrace(String chickenrace) {
        this.chickenrace = chickenrace;
    }





}
