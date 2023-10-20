package coke.controller.camp.PartyRepository;

import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.entity.Board;
import coke.controller.camp.entity.Party;
import coke.controller.camp.repository.PartyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class PartyRepositoryTests {

    @Autowired
    private PartyRepository partyRepository;

//    @Test
//    public void getParties(){
//
//        List<Party> result = partyRepository.getPartiesByBno(206L);
//
//
//        result.forEach(partyDTO -> {
//            partyDTO.changeLocation("test");
//            partyRepository.save(partyDTO);
//        });
//
//    }

//    @Test
//    public void getAppointment(){
//
//        List<Object[]> result = partyRepository.getApplicantsByBno(210L);
//
//
//        result.forEach(objects -> {
//            System.out.println(Arrays.toString(objects));
//        });
//
//    }

//    @Test
//    public void getPartyInfo(){
//       Long result =  partyRepository.getPartyCountingApplicantByBno(210L);

//       System.out.println(result);



//    }


    @Test
    public void getBoardListDateRange(){

        String start = "10/01/2023";
        String end = "10/31/2023";

        List<Object[]> resultList = partyRepository.getBoardListByDateRange(start, end);


        resultList.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });

    }
}
