package org.choongang.game.entities;

import lombok.Data;

@Data
public class Rank {
    private int rank;
    private long total;
    private String userId;
    private String userNm;
}
