package org.choongang.ready.controllers;

import org.choongang.global.Controller;
import org.choongang.ready.ControllerLocatorM2;
import org.choongang.ready.contents.ReadyMenu;

import java.util.HashMap;
import java.util.Map;

public class Menu2ControllerLocator implements ControllerLocatorM2{

    private static ControllerLocatorM2 instance;
    private Map<ReadyMenu, Controller> controllers;

    private Menu2ControllerLocator(){ controllers = new HashMap<>();}
    public static ControllerLocatorM2 getInstance() {
        if (instance == null) {
            instance = new Menu2ControllerLocator();
        }
        return instance;
    }
    @Override
    public Controller find(ReadyMenu readyMenu) {
        Controller controller = controllers.get(readyMenu);
        if(controller != null){
            return controller;
        }
        switch (readyMenu){
            case RULE: controller = new RuleController(); break;
            default: controller = new GameStartController();
        }
        controllers.put(readyMenu, controller);
        return controller;
    }
}
