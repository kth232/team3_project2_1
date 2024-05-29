package org.choongang.member.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;

public class MemberControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private MemberControllerLocator() {}

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

        switch(mainMenu) {
            case JOIN: controller = new JoinController(); break;
            default: controller = new LoginController();
        }

        controllers.put(menu, controller);

        return controller;
    }
}