package coke.controller.camp.repository.Search;

import coke.controller.camp.entity.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PartySearchRepositoryImpl extends QuerydslRepositorySupport implements PartySearchRepository {

    public PartySearchRepositoryImpl() {
        super(Party.class);
    }

    @Override
    public Page<Object[]> getPartyMemberWithGears(Long bno, String direction, String sortType, Pageable pageable) {

        log.info("-------------getPartyMemberWithGears-------------");
        log.info(bno);
        log.info("sortType: " + sortType);
        log.info("direction: " + direction);
        log.info(pageable);

        QParty party = QParty.party;
        QMember member = QMember.member;
        QBoard board = QBoard.board;
        QGear gear = QGear.gear;
        QGearImage gearImage = QGearImage.gearImage;

        JPQLQuery<Party> query = from(party);
        query.leftJoin(member).on(party.member.eq(member));
        query.leftJoin(board).on(party.board.eq(board));
        query.leftJoin(gear).on(gear.member.eq(member));
        query.leftJoin(gearImage).on(gearImage.gear.eq(gear));

        JPQLQuery<Tuple> tuple = query.select(party, member, board, gear, gearImage);

        BooleanBuilder booleanBuilder = new BooleanBuilder();

//        BooleanExpression pnoExpression = party.pno.gt(0L);
//        booleanBuilder.and(pnoExpression);

        BooleanExpression bnoExpression = party.board.bno.eq(bno);
        booleanBuilder.and(bnoExpression);

        // type : 회원순 , 정렬순(sort), 이름순(gname)
        // sort : asc , desc
//        if (sortType != null){
//
//            log.info("with sort");
//
//            BooleanBuilder conditionBuilder = new BooleanBuilder();
//
//            switch (sortType){
//                case "email":
//                    conditionBuilder.and(party.member.email.contains(member.email));
//                    tuple.orderBy(sortType.equals("asc") ? member.email.asc() : member.email.desc());
//                    break;
//                case "sort":
//                    conditionBuilder.and(gear.sort.contains(gear.sort));
//                    tuple.orderBy(sortType.equals("asc") ? gear.sort.asc() : gear.sort.desc());
//                    break;
//                case "gname":
//                    conditionBuilder.and(gear.gname.contains(gear.gname));
//                    tuple.orderBy(sortType.equals("asc") ? gear.gname.asc() : gear.gname.desc());
//                    break;
//            }
//            booleanBuilder.and(conditionBuilder);
//
//        }else if (direction == null && sortType == null){
//            log.info("withOut sort");
//            tuple.orderBy(member.email.asc());
//        }

        tuple.where(booleanBuilder);

        Sort sort = pageable.getSort();

        sort.stream().forEach(order -> {
            Order orderDirection = order.isAscending() ? Order.ASC : Order.DESC;
            String property = order.getProperty();
            log.info("property: " + property);
            log.info("sort: " + sort);

            switch (property){
                case "email":
                    tuple.orderBy(new OrderSpecifier(orderDirection, member.email));
                    break;
                case "sort":
                    tuple.orderBy(new OrderSpecifier(orderDirection, gear.sort));
                    break;
                case "gname":
                    tuple.orderBy(new OrderSpecifier(orderDirection, gear.gname));
                    break;
            }
        });

        log.info(sort);

        tuple.groupBy(gear);

        tuple.offset(pageable.getOffset());
        tuple.limit(pageable.getPageSize());

        List<Tuple> result = tuple.fetch();

        log.info(result);

        Long count = tuple.fetchCount();

        log.info(count);


        return new PageImpl<Object[]>(result.stream().map(t -> t.toArray()).collect(Collectors.toList()), pageable, count);
    }


}