package org.choongang.ranking.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PointLog {
    private long seq;
    private String userId;
    private long point;
    private String message;
}
