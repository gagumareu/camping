package coke.controller.camp.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardImageRepositoryTest {

    @Autowired
    private BoardImageRepository boardImageRepository;

//    @Test
//    public void delete(){
//        boardImageRepository.deleteByBno(235L);
//    }
}
