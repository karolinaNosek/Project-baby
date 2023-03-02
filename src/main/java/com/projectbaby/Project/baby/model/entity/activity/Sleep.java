package com.projectbaby.Project.baby.model.entity.activity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sleep extends Activity {
    private String nap;
    private String deepSleep;

}

