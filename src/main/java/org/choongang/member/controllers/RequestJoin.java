package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RequestJoin { //사용자 요청
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;

}
