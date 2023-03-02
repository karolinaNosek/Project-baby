package com.projectbaby.Project.baby.model.entity.activity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.projectbaby.Project.baby.model.entity.Baby;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name="ACTIVITY_TYPE", discriminatorType=DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes({
@JsonSubTypes.Type(value = Bath.class, name = "bath"),
@JsonSubTypes.Type(value = Diaper.class, name = "diaper"),
@JsonSubTypes.Type(value = Meal.class, name = "meal"),
@JsonSubTypes.Type(value = Play.class, name = "play"),
@JsonSubTypes.Type(value = Sleep.class, name = "sleep"),
@JsonSubTypes.Type(value = Walk.class, name = "walk")
        })
public abstract class Activity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String activityName;
    private LocalTime activityStartTime;
    private LocalTime activityEndTime;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn (name="baby_id")
    private Baby baby;


}
