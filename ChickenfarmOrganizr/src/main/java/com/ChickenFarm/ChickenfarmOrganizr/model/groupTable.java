package com.ChickenFarm.ChickenfarmOrganizr.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Entity
@Table(name = "group_table")
public class groupTable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupid")
    private int groupid;

    private String group_name;



    @OneToMany(mappedBy = "groupTable", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<chicken> chickenList = new ArrayList<>();


    public List<chicken> getChickenList() {
        return chickenList;
    }

    public void setChickenList(List<chicken> chickenList) {
        this.chickenList = chickenList;
    }








    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getGroupid() {
        return groupid;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }


}
