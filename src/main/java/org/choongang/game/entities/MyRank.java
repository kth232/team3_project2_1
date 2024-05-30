package org.choongang.game.entities;

import lombok.Data;

@Data
public class MyRank {
    private long seq;
    private String userId;
    //private int gamecount; //라운드 횟수
    //private int userscore; //라운드당 점수
    private int rank;
    private long point; //누적 점수
}