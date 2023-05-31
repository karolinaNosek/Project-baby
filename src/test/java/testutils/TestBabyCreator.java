package testutils;

import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;

public class TestBabyCreator {
    public static BabyDTO createBabyDTOWithName (String name) {
        BabyDTO babyDTO = new BabyDTO();
        babyDTO.setName(name);
        return babyDTO;
    }

    public static Baby createBabyWithName (String name) {
        Baby baby = new Baby();
        baby.setName(name);
        return baby;
    }

}
