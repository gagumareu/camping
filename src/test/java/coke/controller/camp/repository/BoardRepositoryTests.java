package coke.controller.camp.repository;

import coke.controller.camp.controller.GearController;
import coke.controller.camp.dto.GearDTO;
import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.dto.PageResultDTO;
import coke.controller.camp.service.GearService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private GearService gearService;

    @Autowired
    private GearController gearController;

    @Autowired
    private GearRepository gearRepository;

    @Test
    public void getList(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setSort("sort");
        pageRequestDTO.setDirection("asc");

        PageResultDTO<GearDTO, Object[]> result = gearService.getListWithPagination("user1@email.com", pageRequestDTO);

//        result.getDtoList().stream().forEach(gearDTO -> {
//           GearDTO dto = gearDTO;
//           log.info(dto);
//           System.out.println(dto);
//
//        });

for (GearDTO gearDTO : result.getDtoList()){
    System.out.println(gearDTO.getSort());
}


    }

}
