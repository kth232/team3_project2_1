package org.choongang.global.contents;

import org.choongang.global.Menu;

public enum MainMenu implements Menu {
    //메인 화면3
    MAIN, //메인 화면
    JOIN, //회원가입
    LOGIN, //로그인
    RANKING,//랭킹

    //메인 화면2
    MAIN2, //게임설명 메인 화면2
    RULE, //게임설명
    GAMESTART, //게임실행 준비 화면
    PLAYGAME, //게임 시작 화면

    //메인 화면3
    MAIN3, //다시하기 메인 화면3
    MYRANKING, //순위
    RESTART, //다시 시작
    EXIT //종료 화면
}
