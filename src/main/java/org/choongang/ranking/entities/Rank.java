package org.choongang.ranking.entities;

import lombok.Data;

@Data
public class Rank {
    private int rank;
    private long total;//point total
    private String userId;
    //private String userNm;
}
