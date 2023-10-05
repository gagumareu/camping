package coke.controller.camp.service;

import coke.controller.camp.dto.PartyGearDTO;
import coke.controller.camp.entity.Board;
import coke.controller.camp.entity.Gear;
import coke.controller.camp.entity.PartyGear;

public interface PartyGearService {

    Long register(Long bno, Long gno);


    default PartyGear DTOToEntity(Long bno, Long gno){

        PartyGear partyGear = PartyGear.builder()
                .board(Board.builder().bno(bno).build())
                .gear(Gear.builder().gno(gno).build())
                .build();
        return partyGear;
    }



}
