package org.choongang.game.controllers;

import org.choongang.global.Controller;
import org.choongang.game.ControllerLocatorM2;
import org.choongang.game.contents.Menu2;

import java.util.HashMap;
import java.util.Map;

public class Menu2ControllerLocator implements ControllerLocatorM2{

    private static ControllerLocatorM2 instance;
    private Map<Menu2, Controller> controllers;

    private Menu2ControllerLocator(){ controllers = new HashMap<>();}
    public static ControllerLocatorM2 getInstance() {
        if (instance == null) {
            instance = new Menu2ControllerLocator();
        }
        return instance;
    }
    @Override
    public Controller find(Menu2 menu2) {
        Controller controller = controllers.get(menu2);
        if(controller != null){
            return controller;
        }


        switch (menu2){
            case RULE: controller = new RuleController(); break;
            case GAMESTART: controller = new GameStartController(); break;
            default: controller = new MjpController();
        }
        controllers.put(menu2, controller);
        return controller;
    }
}