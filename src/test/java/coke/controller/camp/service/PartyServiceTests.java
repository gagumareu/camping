package coke.controller.camp.service;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.dto.PartyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
public class PartyServiceTests {

    @Autowired
    private PartyService partyService;



    @Test
    public void checkUserId(){

        int count = partyService.checkAvailableUser(153L, "test@email.com");

        log.info(count);
    }

    @Test
    public void dropOut(){

        String result = partyService.dropOut(153L, "test@email.com");
        log.info(result);
    }



    @Test
    public void getPartyDTO(){
        String partyDTO = partyService.getLocationByBno(154L);

        System.out.println(partyDTO);
    }

}
