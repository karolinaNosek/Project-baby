package com.projectbaby.Project.baby.model.dto.activity;

import lombok.Data;

@Data
public class PlayDTO extends ActivityDTO {
    private String manipulativeGames;
    private String constructionGames;
    private String sensoryGames;
    private String socialGames;
    private String rhytmAndMovementGames;
}
