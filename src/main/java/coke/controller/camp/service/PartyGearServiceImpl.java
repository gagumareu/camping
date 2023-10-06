package coke.controller.camp.service;

import coke.controller.camp.dto.PartyGearDTO;
import coke.controller.camp.entity.PartyGear;
import coke.controller.camp.repository.PartyGearRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PartyGearServiceImpl implements PartyGearService{

    private final PartyGearRepository partyGearRepository;

    @Override
    public Long register(Long bno, Long gno) {

        log.info("-----register-------");
        log.info(bno + "/" + gno);

        PartyGear partyGear = DTOToEntity(bno, gno);

        PartyGear result = partyGearRepository.save(partyGear);

        log.info(result);

        return result.getPgno();
    }

    @Override
    public void deleteAllByBno(Long bno) {

        log.info("---deleteAll--");
        log.info(bno);

        partyGearRepository.deleteAllByBno(bno);

    }
}
