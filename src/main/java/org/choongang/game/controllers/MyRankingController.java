package org.choongang.game.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.GameMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

public class MyRankingController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(GameMenu.MYRANKING, () -> {
            return "처리된 랭킹 목록\n";
        });
        // 랭킹 출력 후 게임 메뉴 이동
        MainRouter.getInstance().change(GameMenu.GAME);
    }

    public void prompt() {
        System.out.print("MENU 선택: ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.out.println(Templates.getInstance().doubleLine());
            System.exit(0); //0: 정상종료/1: 비정상 종료
        }
    }
}