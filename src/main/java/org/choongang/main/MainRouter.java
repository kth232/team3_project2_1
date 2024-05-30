package org.choongang.main;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.contents.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;

import static org.choongang.global.contents.MainMenu.*;

public class MainRouter implements Router {
    private static Router instance; //singleton pattern

    private MainRouter() {}

    public static Router getInstance() {
        if (instance == null){
            instance = new MainRouter();
        }
        return instance;
    }

    @Override
    public void change(Menu menu) {
        ControllerLocator memlocator = MemberControllerLocator.getInstance();
        Controller controller = null;
        if (menu.equals(JOIN)) {
            controller = memlocator.find(JOIN);
        } else if (menu.equals(LOGIN)) {
            controller = memlocator.find(LOGIN);
        } else if (menu.equals(RANKING)) {
            controller = memlocator.find(RANKING);
        }else if (menu.equals(MAIN2)){
            controller = memlocator.find(MAIN2);
        }else if (menu.equals(RULE)){
            controller = memlocator.find(RULE);
        }else if (menu.equals(GAMESTART)){
            controller = memlocator.find(GAMESTART);
        }else if (menu.equals(PLAYGAME)){
            controller = memlocator.find(PLAYGAME);
        }else if (menu.equals(MAIN3)){
            controller = memlocator.find(MAIN3);
        }else if (menu.equals(MYRANKING)){
            controller = memlocator.find(MYRANKING);
        }else if (menu.equals(RESTART)){
            controller = memlocator.find(RESTART);
        }else if (menu.equals(EXIT)){
            controller = memlocator.find(EXIT);
        } else {
            controller = new MainController();
        }

        controller.run(); //common(), show(), prompt()
    }

    @Override
    public void start() {
        while (true) {
            change(MainMenu.MAIN); //첫 화면은 메인 컨트롤러 출력 화면
        }
    }
}
