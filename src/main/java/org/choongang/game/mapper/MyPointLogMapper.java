package org.choongang.game.mapper;

import org.choongang.game.entities.MyPointLog;
import org.choongang.game.entities.MyRank;
import org.choongang.ranking.entities.Rank;

import java.util.List;

public interface MyPointLogMapper {
    int myPointRegister(MyPointLog myPointLog);
    List<MyRank> getRank();
    List<MyRank> getUserScore();
}
