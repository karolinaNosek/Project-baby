package com.projectbaby.Project.baby.model.entity.activity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bath extends Activity {
    private String eveningBath;

}

