package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchMember {
    private String userId;
    private String userNm;
    private String keyword;
    private int sRow; // 페이징 시작 번호
    private int eRow; // 페이징 종료 번호
}
