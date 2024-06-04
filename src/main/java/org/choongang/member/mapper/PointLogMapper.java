package org.choongang.member.mapper;

import org.choongang.game.entities.MyPointLog;
import org.choongang.game.entities.MyRank;

import java.util.List;

public interface PointLogMapper {
    int myPointRegister(MyPointLog myPointLog);
    List<MyRank> getRank();
}