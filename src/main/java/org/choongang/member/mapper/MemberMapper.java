package org.choongang.member.mapper;

import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper { //mapper interface를 통해 자원 접근
    List<MemberMapper> getList();
    Member getRanking(String userId);
}
