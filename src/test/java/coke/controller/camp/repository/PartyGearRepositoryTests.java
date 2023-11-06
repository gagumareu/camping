package coke.controller.camp.repository;

import coke.controller.camp.entity.PartyGear;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest

public class PartyGearRepositoryTests {

    @Autowired
    private PartyGearRepository partyGearRepository;

//    @Test
//    public void deleteByGno(){
//        partyGearRepository.deletePartyGearByGno(34L);
//    }

//    @Test
//    public void getPartyGear(){
//
//        List<PartyGear> result = partyGearRepository.getListPartyGearsByBno(254L);
//
//        result.forEach(partyGear -> {
//            System.out.println(Arrays.asList(partyGear));
//        });
//
//    }

}
