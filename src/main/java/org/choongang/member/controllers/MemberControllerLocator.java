package org.choongang.member.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.ranking.RankingController;

import java.util.HashMap;

public class MemberControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private MemberControllerLocator() {
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new MemberControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        MainMenu mainMenu = (MainMenu)menu;
        switch (mainMenu) {
            case JOIN: controller = new JoinController(); break;
            case LOGIN: controller = new LoginController(); break;
            default:  controller = new RankingController();

        }
        controllers.put(menu, controller); //기존 것이 있으면 기존 것 사용, 없으면 새로 추가
        return controller;
    } 
}
