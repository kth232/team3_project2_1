package org.choongang.game.controllers;

import org.choongang.game.Menu2Router;
import org.choongang.game.contents.Menu2;
import org.choongang.game.entities.MyRank;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.GameMenu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.ranking.entities.Rank;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class MyRankingController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(GameMenu.MYRANKING, () -> {
            return "    _ _ _처리된 랭킹 목록_ _ _\n";
        });
        // MainRouter.getInstance().change(GameMenu.MYRANKING);
        Service<List<Rank>> service = MemberServiceLocator.getInstance().find(MainMenu.RANKING);

        List<Rank> ranks = service.process();
        String ranking = ranks.stream()
                .map(r -> String.format("%d등 - (%s)/%d점", r.getRank(), r.getUserId(), r.getTotal()))
                .collect(Collectors.joining("\n"));
        Templates.getInstance().render(MainMenu.RANKING,() -> ranking);
    }


    static String restart;

    public void prompt() {
        while (true) {
            System.out.print("1. 다시하기\n2. 종료\n\n");
            System.out.print("MENU 선택: ");
            restart = sc.next();


            try {
                int m = Integer.parseInt(restart);
                if (m >= 1 && m <= 2) {
                    change(m);
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("메뉴 1,2 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo) {
        Menu2 menu2 = null;
        switch (menuNo) {
            case 1:
                menu2 = Menu2.GAMESTART; // 게임시작 화면으로 이동
                break;
            case 2:
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);

        }
        Menu2Router.getInstance().change(menu2);
    }
}