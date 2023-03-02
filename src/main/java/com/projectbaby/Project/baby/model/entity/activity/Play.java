package com.projectbaby.Project.baby.model.entity.activity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Play extends Activity {
    private String manipulativeGames;
    private String constructionGames;
    private String sensoryGames;
    private String socialGames;
    private String rhytmAndMovementGames;

}
