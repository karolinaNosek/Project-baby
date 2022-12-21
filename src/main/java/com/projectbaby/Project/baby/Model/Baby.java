package com.projectbaby.Project.baby.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "babies")
public class Baby {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "date_of_birth")
    private String dob;
    @Column (name = "sex")
    private String sex;
    @Column (name = "height")
    private int height;
    @Column (name = "weight")
    private int weight;


    public Baby () {
    super ();
    }

    public Baby(int id, String name, String dob, String sex, int height, int weight) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
