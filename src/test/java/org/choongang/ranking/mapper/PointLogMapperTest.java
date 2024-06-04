package org.choongang.ranking.mapper;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.MainMenu;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.ranking.entities.PointLog;
import org.choongang.ranking.entities.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PointLogMapperTest {

    private MemberMapper memberMapper;
    private Service<RequestJoin> joinService;
    private PointLogMapper mapper;
    private List<Member> members;

    @BeforeEach
    void init() {
        SqlSession session = DBConn.getSession();
        mapper = session.getMapper(PointLogMapper.class);
        memberMapper = session.getMapper(MemberMapper.class);
        joinService = MemberServiceLocator.getInstance().find(MainMenu.JOIN);
        members = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            RequestJoin form = RequestJoin.builder()
                    .userId("play_user" + i)
                    .userPw("12345678")
                    .build();
            joinService.process(form);

            Member member = memberMapper.get(form.getUserId());
            members.add(member);
        }

    }

    @Test
    void mapperTest1() {
        for (Member member : members) {
            for (int i = 0; i < 50; i++) {
                int point = (int)(Math.random() * 3 - 1) * 10; // -10, 0, 10

                PointLog item = PointLog.builder()
                        .userId(member.getUserId())
                        .point(point)
                        .message("테스트 포인트")
                        .build();

                mapper.register(item);
            } // endfor
        } // endfor
    }

    @Test
    void mapperTest2() {
        List<Rank> ranks = mapper.getRank();
        ranks.forEach(System.out::println);
    }
}
