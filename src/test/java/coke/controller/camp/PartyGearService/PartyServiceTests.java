package coke.controller.camp.PartyGearService;

import coke.controller.camp.dto.*;
import coke.controller.camp.service.PartyService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
public class PartyServiceTests {

    @Autowired
    private PartyService partyService;

//    @Test
//    public void getPartyGearByBno(){
//
//        Pageable pageable = PageRequest.of(0, 20, Sort.by("gno").descending());
//
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//
//        PageResultDTO<PartyGearDTO, Object[]> result = partyService.getPartyGearsListWithPagination(160L, pageRequestDTO);
//
//        result.getDtoList().forEach(partyDTO -> {
//            System.out.println(partyDTO);
//        });
//    }

//    @Test
//    public void getApplicant(){
//
//        List<PartyDTO> result = partyService.getApplicantsByBno(210L);
//
//        result.forEach(partyDTO -> {
//            System.out.println(partyDTO);
//        });
//    }

    @Test
    public void getBoardListDate(){

        List<BoardDTO> resultList = partyService.getPartiesNBoardsListByEmail("user1@email.com");

        resultList.forEach(objects -> {
            System.out.println(objects);
        });

    }


    @Test
    public void getBoardListDateRange(){

        List<BoardDTO> resultList = partyService.getPartiesNBoardsRangeListByEmail("11/01/2023", "11/30/2023", "user1@email.com");

        resultList.forEach(objects -> {
            System.out.println(objects);
        });

    }



}
