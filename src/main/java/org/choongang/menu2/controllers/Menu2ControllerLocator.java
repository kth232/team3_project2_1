package org.choongang.menu2.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.contents.Menu;
import org.choongang.menu2.ControllerLocatorM2;
import org.choongang.menu2.contents.Menu2;

import java.util.HashMap;
import java.util.Map;

public class Menu2ControllerLocator implements ControllerLocatorM2 {

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
            case RULE: controller = new Rule(); break;
            default: controller = new GameStart();
        }
        controllers.put(menu2,controller);
        return controller;
    }
}
