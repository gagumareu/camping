package coke.controller.camp.repository.Search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PartySearchRepository {

    Page<Object[]> getPartyMemberWithGears(Long bno, String direction, String sort, Pageable pageable);
}
