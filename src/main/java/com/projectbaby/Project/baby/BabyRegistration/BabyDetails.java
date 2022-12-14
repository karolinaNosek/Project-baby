package com.projectbaby.Project.baby.BabyRegistration;

import org.springframework.format.annotation.DateTimeFormat;

public class BabyDetails {

    private String name;

    @DateTimeFormat
    private int dob;
    private String sex;
    private int height;
    private int weight;



}
