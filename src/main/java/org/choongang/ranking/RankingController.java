package org.choongang.ranking;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.ranking.entities.Rank;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class RankingController extends AbstractController {

    @Override
    public void show() {
        Service<List<Rank>> service = MemberServiceLocator.getInstance().find(MainMenu.RANKING);

        List<Rank> ranks = service.process();
        String ranking = ranks.stream()
                .map(r -> String.format("%d등 - (%s)/%d점", r.getRank(), r.getUserId(), r.getTotal()))
                .collect(Collectors.joining("\n"));
        Templates.getInstance().render(MainMenu.RANKING,() -> ranking);

        //랭킹 출력 후 메인 메뉴 이동
        MainRouter.getInstance().change(MainMenu.MAIN);
    }


}
