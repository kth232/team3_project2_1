package org.choongang.ranking.services;

import org.choongang.global.Service;
import org.choongang.ranking.entities.PointLog;

//포인트로그가 "들어오면" 입력하는 형식 - 메서드 오버라이드 (둘 중 매개변수 있는 형태)
public class PointLogService implements Service<PointLog> {
    @Override
    public void process(PointLog form) {

    }
}
