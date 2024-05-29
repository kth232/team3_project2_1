package org.choongang.game.mapper;

import org.choongang.game.entities.MyRank;
import org.choongang.game.entities.PointLog;

import java.util.List;

public interface MyRankingMapper {
    int register(PointLog pointLog);
    List<MyRank> getUserScore();

}
