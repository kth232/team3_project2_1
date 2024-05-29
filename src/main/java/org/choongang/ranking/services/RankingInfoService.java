package org.choongang.ranking.services;

import org.choongang.global.Service;
import org.choongang.ranking.entities.Rank;
import org.choongang.ranking.mapper.PointLogMapper;

import java.util.List;

public class RankingInfoService implements Service<List<Rank>> {

    private final PointLogMapper mapper;

    public RankingInfoService(PointLogMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<Rank> process() {
        return mapper.getRank();
    }
}
