package org.choongang.member.mapper;

import org.choongang.member.controllers.SearchMember;
import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper { //mapper interface를 통해 자원 접근
    List<Member> getList(SearchMember search);
    Member get(String userId);
    long getTotal(SearchMember search);
    int exist(String userId);
    int register(Member member);
    int modify(Member member);
    int delete(String userId);
}
