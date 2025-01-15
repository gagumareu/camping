package coke.controller.camp.repository;

import coke.controller.camp.entity.PartyGear;
import coke.controller.camp.repository.Search.PartySearchRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartyGearRepository extends JpaRepository<PartyGear, Long> {

    @Modifying
    @Query("DELETE FROM PartyGear pg WHERE pg.board.bno = :bno")
    int deleteAllByBno(Long bno);

    @Modifying
    @Query("DELETE FROM PartyGear pg WHERE pg.board.bno = :bno AND pg.member.email = :email")
    int deleteAllByBnoAndEmail(Long bno, String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM PartyGear pg WHERE pg.gear.gno = :gno")
    int deletePartyGearByGno(Long gno);

    @Transactional
    @Query("SELECT pg FROM PartyGear pg WHERE pg.board.bno = :bno")
    List<PartyGear> getListPartyGearsByBno(Long bno);

}
