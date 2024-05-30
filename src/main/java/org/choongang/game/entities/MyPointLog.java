package org.choongang.game.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyPointLog {
    private long seq;
    private long userNo;
    private long point;
    private String message; }
