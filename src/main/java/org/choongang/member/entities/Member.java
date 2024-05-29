package org.choongang.member.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Member {
    private String userId;
    private String userPw;
    private String point;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
