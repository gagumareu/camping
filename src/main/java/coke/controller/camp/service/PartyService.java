package coke.controller.camp.service;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.dto.PartyGearDTO;
import coke.controller.camp.entity.*;

import java.util.List;

public interface PartyService {

    Long save(PartyDTO partyDTO);
    PageResultDTO<PartyDTO, Object[]> getPartyByBnoWithList(Long bno, PageRequestDTO pageRequestDTO);
    PageResultDTO<PartyGearDTO, Object[]> getPartyGearsListWithPagination(Long bno, PageRequestDTO pageRequestDTO);
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
                .dDay(partyDTO.getDDay())
                .person(partyDTO.getPerson())
                .build();
        return party;
    }

    default PartyDTO entityToDTO(Party party, Member member, Board board, Gear gear, GearImage gearImage){

        PartyDTO partyDTO = PartyDTO.builder()
                .pno(party.getPno())
                .bno(board.getBno())
                .location(party.getLocation())
                .dDay(party.getDDay())
                .person(party.getPerson())
                .email(member.getEmail())
                .memberName(member.getMemberName())
                .profileImg(member.getProfileImg())
                .build();

        if (gear != null){
            partyDTO.setGno(gear.getGno());
            partyDTO.setGname(gear.getGname());
            partyDTO.setState(gear.getState());
            partyDTO.setSort(gear.getSort());
            partyDTO.setBrand(gear.getBrand());
        }
        if (gearImage != null){
            partyDTO.setIno(gearImage.getIno());
            partyDTO.setFileName(gearImage.getFileName());
            partyDTO.setS3Url(gearImage.getS3Url());
        }

        return partyDTO;

    }

    default PartyGearDTO PartyGearEntityToDTO(PartyGear partyGear, Member member, Gear gear, GearImage gearImage){

        PartyGearDTO partyGearDTO = PartyGearDTO.builder()
                .pgno(partyGear.getPgno())
                .gno(gear.getGno())
                .gname(gear.getGname())
                .brand(gear.getBrand())
                .sort(gear.getSort())
                .state(String.valueOf(gear.getState()))
                .email(member.getEmail())
                .memberName(member.getMemberName())
                .profileImg(member.getProfileImg())
                .build();


        if (gearImage != null){
            partyGearDTO.setS3Url(gearImage.getS3Url());
        }
        return partyGearDTO;
    }


}
