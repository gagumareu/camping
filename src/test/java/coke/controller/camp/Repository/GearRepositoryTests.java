package coke.controller.camp.Repository;

import coke.controller.camp.dto.GearDTO;
import coke.controller.camp.entity.Board;
import coke.controller.camp.entity.Gear;
import coke.controller.camp.repository.GearRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class GearRepositoryTests {

    @Autowired
    private GearRepository gearRepository;

    @Test
    public void gearList(){

        String email = "user1@email.com ";

        List<Object[]> result = gearRepository.getGearByEmailOrderByGnoDesc(email);

        for (Object[] objects : result) {
            System.out.println(Arrays.asList(objects));

        }
    }

    @Test
    public void updateState(){

        GearDTO gearDTO = GearDTO.builder()
                .gno(38L)
                .state(1)
                .build();

        Optional<Gear> result = gearRepository.findById(gearDTO.getGno());

        Gear gear = result.orElseThrow();

        gear.changeState(gearDTO.getState());


        gearRepository.save(gear);

    }

    @Test
    public void getGear(){

        Optional<Gear> result = gearRepository.getGearByBoard(Board.builder().bno(69L).build());

        Gear gear = result.orElseThrow();

        System.out.println(gear);
    }



}
