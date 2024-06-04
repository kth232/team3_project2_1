package org.choongang.game.controllers;

import org.choongang.game.contents.Menu2;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

import java.util.HashMap;
import java.util.Map;

public class Menu2ControllerLocator implements ControllerLocator {

    private static ControllerLocator instance;
    private Map<Menu2, Controller> controllers;

    private Menu2ControllerLocator(){ controllers = new HashMap<>();}
    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new Menu2ControllerLocator();
        }
        return instance;
    }
    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null){
            return controller;
        }
        if(menu instanceof Menu2) {
            Menu2 menu2 = (Menu2)menu;
            switch (menu2) {
                case RULE:
                    controller = new RuleController();
                    break;
                case GAMESTART:
                    controller = new GameStartController();
                    break;
                default:
                    controller = new MjpController();
                }
            } else{
                System.out.println("정확한 메뉴명을 입력해주세요");
        }
        return controller;
    }
}