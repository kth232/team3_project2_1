package org.choongang.member.validators;

import org.choongang.global.exceptions.ValidationException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mapper.MemberMapper;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator {

    private final MemberMapper mapper;

    public JoinValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void check(RequestJoin form) {
        // 필수 항목 체크 S
        String userId = form.getUserId();
        String userPw = form.getUserPw();

        checkRequired(userId, new ValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new ValidationException("비밀번호를 입력하세요."));
        // 필수 항목 체크 E

        // 아이디 자리수 체크(6자리 이상)
        if (userId == null || userId.length() < 6) {
            throw new ValidationException("아이디는 6자리 이상 입력하세요.");
        }

        // 아이디 중복 여부 체크
        if (mapper.exist(userId) > 0) {
            throw new ValidationException("이미 등록된 아이디 입니다.");
        }

        // 비밀번호 자리수 체크(8자리 이상)
        if (userPw == null || userPw.length() < 8) {
            throw new ValidationException("비밀번호는 8자리 이상 입력하세요.");
        }

    }
}