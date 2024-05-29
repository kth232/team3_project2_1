package org.choongang.ranking.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PointLog {
    private long seq;
    private int userId;
    private long point;
    private String message;
}
