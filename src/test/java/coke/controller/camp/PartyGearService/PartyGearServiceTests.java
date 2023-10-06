package coke.controller.camp.PartyGearService;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.dto.PartyGearDTO;
import coke.controller.camp.repository.PartyRepository;
import coke.controller.camp.service.PartyGearService;
import coke.controller.camp.service.PartyService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.stream.Collectors;

@SpringBootTest
@Log4j2
public class PartyGearServiceTests {

    @Autowired
    private PartyService partyService;

    @Test
    public void getPartyGearByBno(){

        Pageable pageable = PageRequest.of(0, 20, Sort.by("gno").descending());

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<PartyGearDTO, Object[]> result = partyService.getPartyGearsListWithPagination(160L, pageRequestDTO);

        result.getDtoList().forEach(partyDTO -> {
            System.out.println(partyDTO);
        });
    }

}
