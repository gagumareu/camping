package coke.controller.camp.repository;

import coke.controller.camp.dto.PartyDTO;
import coke.controller.camp.entity.Board;
import coke.controller.camp.entity.Party;
import coke.controller.camp.entity.QParty;
import coke.controller.camp.repository.Search.PartySearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, Long>, PartySearchRepository {

    @Query("SELECT p, m, g, gi " +
            "FROM Party p " +
            "LEFT JOIN p.member m " +
            "LEFT JOIN Gear g ON g.member = m " +
            "LEFT JOIN GearImage gi ON gi.gear = g " +
            "WHERE p.board.bno = :bno " +
            "group by g")
    List<Object[]> getPartyByBno(Long bno);

    @Query("select count (p) FROM Party p WHERE p.board.bno = :bno AND p.member.email = :email")
    int getPartyByBnoAndEmail(Long bno, String email);

    @Modifying
    @Query("DELETE FROM Party p WHERE p.board.bno = :bno AND p.member.email = :email")
    int dropOutFromParty(Long bno, String email);

    @Query("SELECT distinct (p.location) FROM Party p WHERE p.board.bno = :bno")
    String getLocationByBno(Long bno);

    @Modifying
    @Query("DELETE FROM Party p WHERE p.board.bno = :bno")
    void deletePartiesByBno(Long bno);

    @Query("SELECT p FROM Party p WHERE p.board.bno = :bno")
    List<Party> getPartiesByBno(Long bno);

    @Query("SELECT p , m FROM Party p LEFT JOIN p.member m WHERE p.board.bno = :bno")
    List<Object[]> getApplicantsByBno(Long bno);

    @Query("SELECT count (p.board.bno) FROM Party p where p.board.bno = :bno")
    Long getPartyCountingApplicantByBno(Long bno);

    @Query("SELECT p FROM Party p WHERE p.board.bno = :bno")
    Party getParty(Long bno);


}
