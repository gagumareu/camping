package coke.controller.camp.service;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.entity.*;

import java.util.List;

public interface PartyService {

    Long save(PartyDTO partyDTO);
    PageResultDTO<PartyDTO, Object[]> getPartyByBnoWithList(Long bno, PageRequestDTO pageRequestDTO);
    int checkAvailableUser(Long bno, String email);
    String dropOut(Long bno, String email);
    String getLocationByBno(Long bno);
    void removePartiesByBno(Long bno);

    default Party dtoToEntity(PartyDTO partyDTO){

        Party party = Party.builder()
                .pno(partyDTO.getPno())
                .board(Board.builder().bno(partyDTO.getBno()).build())
                .member(Member.builder().email(partyDTO.getEmail()).build())
                .location(partyDTO.getLocation())
                .build();
        return party;
    }

    default PartyDTO entityToDTO(Party party, Member member, Board board, Gear gear, GearImage gearImage){

        PartyDTO partyDTO = PartyDTO.builder()
                .pno(party.getPno())
                .bno(board.getBno())
                .location(party.getLocation())
                .email(member.getEmail())
                .userName(member.getMemberName())
                .profileImg(member.getProfileImg())
                .build();

        if (gear != null){
            partyDTO.setGno(gear.getGno());
            partyDTO.setGname(gear.getGname());
            partyDTO.setState(gear.getState());
            partyDTO.setSort(gear.getSort());
        }
        if (gearImage != null){
            partyDTO.setIno(gearImage.getIno());
            partyDTO.setFileName(gearImage.getFileName());
            partyDTO.setS3Url(gearImage.getS3Url());
        }

        return partyDTO;

    }


}
