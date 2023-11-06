package coke.controller.camp.gearService;

import coke.controller.camp.dto.PartyGearDTO;
import coke.controller.camp.service.PartyGearService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PartyGearServiceTests {

    @Autowired
    private PartyGearService partyGearService;

//    @Test
//    public void getPartyGearList(){
//
//        List<PartyGearDTO> list =  partyGearService.getPartyListByBno(254L);
//
//        list.forEach(partyGearDTO -> {
//            System.out.println(partyGearDTO);
//        });
//
//    }


}
