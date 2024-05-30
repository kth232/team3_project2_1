package org.choongang.game.services;

import org.choongang.game.entities.MyRank;
import org.choongang.game.mapper.MyPointLogMapper;
import org.choongang.global.Service;
import org.choongang.ranking.entities.Rank;

import java.util.List;

public class MyRankingInfoService implements Service<List<Rank>> {

    private final MyPointLogMapper mapper;

    public MyRankingInfoService(MyPointLogMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MyRank> process() {

        return mapper.getRank();
    }
}
