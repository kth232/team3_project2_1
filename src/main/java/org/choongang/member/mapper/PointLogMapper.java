package org.choongang.member.mapper;

import org.choongang.game.entities.PointLog;
import org.choongang.game.entities.Rank;

import java.util.List;

public interface PointLogMapper {
    int register(PointLog pointLog);
    List<Rank> getRank();
}