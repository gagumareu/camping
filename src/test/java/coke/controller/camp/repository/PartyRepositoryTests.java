package coke.controller.camp.repository;

import coke.controller.camp.entity.Board;
import coke.controller.camp.entity.Member;
import coke.controller.camp.entity.Party;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
public class PartyRepositoryTests {

    @Autowired
    private PartyRepository partyRepository;

    @Test
    public void getParty(){


        List<Object[]> result = partyRepository.getPartyByBno(144L);

        result.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });

    }

    @Test
    public void joinParty(){

        Party party = Party.builder()
                .board(Board.builder().bno(144L).build())
                .member(Member.builder().email("user1@email.com").build())
                .location(null).build();

        partyRepository.save(party);
    }

    @Test
    public void getPartyWithList(){

        String direction = "desc";
        String sort = "sort";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("email").ascending());

        Page<Object[]> result = partyRepository.getPartyMemberWithGears(144L, direction, sort, pageable);

        result.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });
    }
}
