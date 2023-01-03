package com.projectbaby.Project.baby.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "babies")
public class Baby {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column (name = "sex")
    private String sex;
    @Column (name = "height")
    private int height;
    @Column (name = "weight")
    private int weight;


    public Baby () {
    super ();
    }

    public Baby(int id, String name, LocalDate dateOfBirth, String sex, int height, int weight) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
