package com.projectbaby.Project.baby.model.entity.activity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Diaper extends Activity {
    private String pee;
    private String poo;

}
