package org.choongang.game.controllers;

import org.choongang.game.entities.MyRank;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.contents.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.List;

public class MyRankingController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.MYRANKING, () -> return "처리된 랭킹 목록\n";
    });
    MainRouter.getInstance().change(MainMenu.MYRANKING);

    Service<List<MyRank>> service = MyRankingServiceLocator.getInstance().find(MainMenu.MYRANKING);

        Templates.getInstance().render(MainMenu.MYRANKING);


@Override
    public void prompt() {
    System.out.print("게임종료");
    String menu = sc.nextLine();
    if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        System.out.println(Templates.getInstance().doubleLine());
        System.exit(0); //0: 정상종료/1: 비정상 종료
    }
}

