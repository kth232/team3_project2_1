package org.choongang.game.services;

import org.choongang.game.entities.MyRank;
import org.choongang.global.Service;

import java.util.List;

//
public class MyRankInfoService implements Service<List<MyRank>> {
    private final MyPointLogMapper mapper;

    public MyRankingInfoService(MyPointLogMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MyRank> process() {
        return mapper.getRank();
    }
}
