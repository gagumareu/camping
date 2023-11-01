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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
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
    public void getBoardListDateByEmail(){

        List<Object[]> resultList = partyRepository.getPartiesBoardListByEmail("user1@email.com");

        resultList.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });

    }

    @Test
    public void getBoardListDateRange(){

        LocalDate start = LocalDate.of(2023,10,01);
        LocalDate end = LocalDate.of(2024,04,30);

        List<Object[]> resultList = partyRepository.getPartiesBoardListByDateRangeNEmail(start, end,"user1@email.com");

        resultList.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });

    }


    @Test
    public void getPartiesAllList(){

        LocalDate start = LocalDate.of(2023,10,01);
        LocalDate end = LocalDate.of(2024,12,30);


        List<Object[]> resultList = partyRepository.getPartiesAllListWithRange(start, end);

        resultList.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });

    }

    @Test
    public void getPartyInfo(){

       Party party = partyRepository.getPartyInfoByBno(216L);

        System.out.println(party);
//        Party party1 = party.orElseThrow();
//        party.forEach(party1 -> {
//            System.out.println(party1);
//        });


    }






}
