package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.global.exceptions.ValidationException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;

@RequiredArgsConstructor
public class JoinService implements Service<RequestJoin> {

    private final MemberMapper mapper;
    private final JoinValidator validator;

    @Override
    public void process(RequestJoin form) {
        // 회원 가입 유효성 검사
        validator.check(form);

        // 비밀번호 해시화
        String userPw = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(10));


        // 데이터베이스에 영구 저장
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(userPw)
                .build();
        int affectedRows = mapper.register(member);

        if (affectedRows < 1) { // 회원 가입 처리 실패시
            throw new ValidationException("회원가입 실패하였습니다.");
        }

    }
}