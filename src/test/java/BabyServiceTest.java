import com.projectbaby.Project.baby.mapper.BabyMapper;
import com.projectbaby.Project.baby.model.dto.BabyDTO;
import com.projectbaby.Project.baby.model.entity.Baby;
import com.projectbaby.Project.baby.repository.BabyRepository;
import com.projectbaby.Project.baby.service.BabyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import testutils.TestBabyCreator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import(BabyService.class)
class BabyServiceTest {

    @MockBean
    private BabyRepository babyRepository;
    @MockBean
    private BabyMapper babyMapper;
    @Autowired
    private BabyService babyService;


    @Test
    void verifyIfBabyDTOWasSaved () {

        //given
        BabyDTO babyDTO = TestBabyCreator.createBabyDTOWithName("Aleks");
        Baby mappedBaby = TestBabyCreator.createBabyWithName("Aleks");
        when(babyMapper.mapToBaby(any())).thenReturn(mappedBaby);
        when(babyRepository.save(any())).thenReturn(mappedBaby);
        when(babyMapper.mapToBabyDTO(any())).thenReturn(babyDTO);

        //when
        BabyDTO savedBabyDTO = babyService.save(babyDTO);


        //then
        Assertions.assertEquals(babyDTO.getName(), savedBabyDTO.getName());


    }

//    @Test
//    void verifyIfBabyDTOWasUpdatedByWeight () {
//
//       //given
//        BabyDTO expectedBabyDTO = new BabyDTO();
//
//        //when
//        babyService.update(expectedBabyDTO);
//
//        //then
//
//
//    }
//
//
//    @Test
//    void verifyIfBabyDTOWasDeletedById (){
//
//       //given
//
//        //when
//
//        //then
//    }
//
//    @Test
//    void verifyIfBabyWasFoundForThisID (){
//        //given
//        // tworze dziecko z jakims id
//        //when
//        //metoda findbyid
//        //then
//        //
//    }
}
