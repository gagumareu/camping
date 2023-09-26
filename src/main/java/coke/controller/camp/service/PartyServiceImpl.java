package coke.controller.camp.service;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.entity.*;
import coke.controller.camp.repository.PartyRepository;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService{

    private final PartyRepository partyRepository;

    @Override
    public Long save(PartyDTO partyDTO) {

        log.info("------save------");
        log.info(partyDTO);

        Party party = dtoToEntity(partyDTO);

        Party result = partyRepository.save(party);

        return result.getPno();
    }

    @Override
    public PageResultDTO<PartyDTO, Object[]> getPartyByBnoWithList(Long bno, PageRequestDTO pageRequestDTO) {

       log.info("--------getPartyByBnoWithList---------");
       log.info(bno);
       log.info(pageRequestDTO);

        Function<Object[], PartyDTO> fn = (en -> entityToDTO(
                (Party) en[0],
                (Member) en[1],
                (Board) en[2],
                (Gear) en[3],
                (GearImage) en[4]
        ));

        String dir = pageRequestDTO.getDirection() == null ? "asc" : pageRequestDTO.getDirection();
        String str = pageRequestDTO.getSort() == null ? "email" : pageRequestDTO.getSort();

        Sort sort = dir.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, str) : Sort.by(Sort.Direction.DESC, str);

        Pageable pageable = PageRequest.of(0, 20, sort);

        Page<Object[]> result = partyRepository.getPartyMemberWithGears(
                bno,
                pageRequestDTO.getDirection(),
                pageRequestDTO.getSort(),
                pageable);

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public int checkAvailableUser(Long bno, String email) {

        log.info("--------checkAvailableUser------------");
        log.info(bno);
        log.info(email);

        int count = partyRepository.getPartyByBnoAndEmail(bno, email);

        return count;
    }

    @Transactional
    @Override
    public String dropOut(Long bno, String email) {

        log.info("--------dropOut from a party-------------");
        log.info(bno);
        log.info(email);

        String result = "";

       int count = partyRepository.dropOutFromParty(bno, email);
       log.info(result);

       if (count == '1'){
           result = "success";
       }else {
           result = "fail";
       }

       return result;
    }

    @Override
    public PartyDTO getPartyDTO(Long bno) {

        log.info(bno);

        return partyRepository.getPartyByEmail(bno);
    }


}
