package org.choongang.game.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;

public class RankingControllerLocator extends AbstractControllerLocator {

    private static RankingControllerLocator instance;

    private RankingControllerLocator() {}

    public static RankingControllerLocator getInstance() {
        if(instance == null) {
            instance = new RankingControllerLocator() {
            };
        }
        return instance;
    }

    public Controller find(Menu menu) {

        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        // 게임 서브 메뉴
        if(menu instanceof Menu) {
            MainMenu mainMenu = (MainMenu)menu;
            switch (mainMenu) {
                case MYRANKING: controller = new RankingController(); break;
                case RESTART: controller = new RankingController(); break; // 컨트롤러 변경
                case EXIT: controller = new ExitController(); break;
            }
        } else{ // 게임 메인 메뉴
            System.out.println("정확한 메뉴명을 입력해주세요");
        }

        return controller;
    }
}
