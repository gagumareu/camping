package coke.controller.camp.Repository;

import coke.controller.camp.dto.PageRequestDTO;
import coke.controller.camp.entity.Board;
import coke.controller.camp.repository.BoardRepository;
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
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void boardList(){

        String type = null;
        String keyword = null;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        String category = null;
        Page<Object[]> resultList = boardRepository.getSearchList(type, keyword, pageable, category);

        resultList.forEach(objects -> {
            System.out.println(Arrays.asList(objects));
        });

    }

}
