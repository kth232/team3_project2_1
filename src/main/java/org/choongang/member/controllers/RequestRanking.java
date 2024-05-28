package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RequestRanking {
    private String userId;
    private String point;
    private String ranking;
}