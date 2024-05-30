package org.choongang.game.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.Menu;
import org.choongang.global.constants.GameMenu;

public class MyRankingControllerLocator extends AbstractControllerLocator {

    private static MyRankingControllerLocator instance;

    private MyRankingControllerLocator() {}

    public static MyRankingControllerLocator getInstance() {
        if(instance == null) {
            instance = new MyRankingControllerLocator() {
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
        if(menu instanceof GameMenu) {
            GameMenu gameMenu = (GameMenu)menu;
            switch (gameMenu) {
                case MYRANKING: controller = new MyRankingController(); break;
                case RESTART: controller = new MyRankingController(); break; // 컨트롤러 변경
                case EXIT: controller = new ExitController(); break;
            }
        } else{
            System.out.println("정확한 메뉴명을 입력해주세요");
        }

        return controller;
    }
}
