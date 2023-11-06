package coke.controller.camp.service;

import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.dto.PartyGearDTO;
import coke.controller.camp.entity.Board;
import coke.controller.camp.entity.Gear;
import coke.controller.camp.entity.Member;
import coke.controller.camp.entity.PartyGear;

import java.util.List;

public interface PartyGearService {

    Long register(Long bno, PartyGearDTO partyGearDTO);
    int deleteAllByBno(Long bno);
    int deletePartyGearByGno(Long gno);
    List<PartyGearDTO> getPartyListByBno(Long bno);

    default PartyGear DTOToEntity(Long bno, PartyGearDTO partyGearDTO){

        PartyGear partyGear = PartyGear.builder()
                .board(Board.builder().bno(bno).build())
                .gear(Gear.builder().gno(partyGearDTO.getGno()).build())
                .member(Member.builder().email(partyGearDTO.getEmail()).build())
                .build();
        return partyGear;
    }

    default PartyGearDTO entityToDTO(PartyGear partyGear){

        PartyGearDTO partyGearDTO = PartyGearDTO.builder()
                .pgno(partyGear.getPgno())
                .bno(partyGear.getBoard().getBno())
                .gno(partyGear.getGear().getGno())
                .email(partyGear.getMember().getEmail())
                .build();
        return partyGearDTO;
    }



}
