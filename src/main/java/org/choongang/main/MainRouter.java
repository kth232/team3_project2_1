package org.choongang.main;

import org.choongang.game.controllers.MyRankingControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.GameMenu;
import org.choongang.global.constants.MainMenu;

import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;

import static org.choongang.global.constants.MainMenu.*;


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
        ControllerLocator myrank = MyRankingControllerLocator.getInstance();
        Controller controller = null;
        if (menu.equals(JOIN)) {
            controller = memlocator.find(JOIN);
        } else if (menu.equals(LOGIN)) {
            controller = memlocator.find(LOGIN);
        } else if (menu.equals(RANKING)) {
            controller = memlocator.find(RANKING);
        } else if (menu.equals(GameMenu.MYRANKING)) {
            controller = myrank.find(GameMenu.MYRANKING);
        }
        else{
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
