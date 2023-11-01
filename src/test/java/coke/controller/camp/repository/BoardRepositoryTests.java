package coke.controller.camp.PartyRepository;

import coke.controller.camp.entity.Board;
import coke.controller.camp.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void getListWithTalkCategory(){

        List<Object[]> boardList =boardRepository.getBoardListByCategoryTalkLimit20();

        boardList.forEach(board -> {
            System.out.println(Arrays.toString(board));
        });

    }

    @Test
    public void getListWithSecondHansCategory(){

        List<Object[]> boardList =boardRepository.getBoardListByCategorySecondHansLimit20();

        boardList.forEach(board -> {
            System.out.println(Arrays.toString(board));
        });

    }





}
