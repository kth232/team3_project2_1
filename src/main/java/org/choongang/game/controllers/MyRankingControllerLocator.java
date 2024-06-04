package org.choongang.game.controllers;

import org.choongang.game.contents.Menu2;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.Menu;

import java.util.HashMap;
import java.util.Map;

public class MyRankingControllerLocator extends AbstractControllerLocator {

    private static MyRankingControllerLocator instance;
    private Map<Menu, Controller> controllers;

    private MyRankingControllerLocator() { controllers = new HashMap<>();}

    public static AbstractControllerLocator getInstance() {
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
        if(menu instanceof Menu2) {
            Menu2 menu2 = (Menu2)menu;
            switch (menu2) {
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
