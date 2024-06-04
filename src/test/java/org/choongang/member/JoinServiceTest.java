package org.choongang.member;
import org.choongang.global.configs.DBConn;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JoinServiceTest {

    private MemberMapper mapper;
    private Member member;

    @BeforeEach
    void init() {
        mapper = DBConn.getSession().getMapper(MemberMapper.class);
        //member = Member.builder()

    }

    @Test
    @DisplayName("회원 가입시 예외 발생이 없고, 추가한 회원으로 조회가 되면 성공")
    void registerTest() {

    }
}