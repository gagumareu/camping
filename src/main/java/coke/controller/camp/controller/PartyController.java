package coke.controller.camp.controller;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.service.PartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party/")
@Log4j2
@RequiredArgsConstructor
public class PartyController {

    private final PartyService partyService;

    @GetMapping(value = "/{bno}/{sortType}/{direction}/{page}")
    public ResponseEntity<PageResultDTO<PartyDTO, Object[]>> getPartyMemberGearList(@PathVariable("bno") Long bno,
                                                                @PathVariable("sortType") String sortType,
                                                                @PathVariable("direction") String direction,
                                                                @PathVariable("page") int page,
                                                                PageRequestDTO pageRequestDTO){

        log.info(bno);
        log.info("sortType: " + sortType);
        log.info("direction: " + direction);
        log.info("page: " + page);
        log.info(pageRequestDTO);

        pageRequestDTO.setPage(page);
        pageRequestDTO.setSort(sortType);
        pageRequestDTO.setDirection(direction);

        PageResultDTO<PartyDTO, Object[]> resultDTO = partyService.getPartyByBnoWithList(bno, pageRequestDTO);

        return new ResponseEntity<>(resultDTO, HttpStatus.OK);

    }

    @PostMapping(value = "/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> joinParty(@RequestBody PartyDTO partyDTO){

        log.info("-------join party--------");
        log.info(partyDTO);

        Long rno = partyService.save(partyDTO);

        return new ResponseEntity<>(rno, HttpStatus.OK);
    }

    @GetMapping(value = "/{bno}/{currentUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> checkAvailableUser(@PathVariable("bno") Long bno, @PathVariable("currentUser") String email){

        log.info("------------checkAvailableUser-------");
        log.info(bno);
        log.info(email);

        int count = partyService.checkAvailableUser(bno, email);
        log.info(count);

        return new ResponseEntity<Integer>(count, HttpStatus.OK );
    }

    @DeleteMapping(value = "/{bno}/{currentUser}")
    public ResponseEntity<String> dropOut(@PathVariable("bno") Long bno, @PathVariable("currentUser") String email){

        log.info("------------dropOut-------");
        log.info(bno);
        log.info(email);

        String result = partyService.dropOut(bno, email);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{bno}")
    public ResponseEntity<String> getLocation(@PathVariable("bno") Long bno){

        log.info("--------get location--------");
        log.info(bno);

        String address = partyService.getLocationByBno(bno);

        log.info(address);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }



}
