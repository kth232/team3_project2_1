package org.choongang.ranking.mapper;

import org.choongang.ranking.entities.PointLog;
import org.choongang.ranking.entities.Rank;

import java.util.List;

public interface PointLogMapper {
    int register(PointLog pointLog);
    List<Rank> getRank();
}
