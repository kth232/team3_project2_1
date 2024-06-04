package org.choongang.main;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;

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
        //ControllerLocator myrank = MyRankingControllerLocator.getInstance();
        Controller controller = null;

        MainMenu mainMenu = (MainMenu) menu;
        switch (mainMenu) {
            case JOIN:
                controller = memlocator.find(MainMenu.JOIN);
                break;
            case LOGIN:
                controller = memlocator.find(MainMenu.LOGIN);
                break;
            case RANKING:
                controller = memlocator.find(MainMenu.RANKING);
                break;
            default:
                controller = new MainController();
        }
        /*
        if (menu.equals(JOIN)) {
            controller = memlocator.find(JOIN);
        } else if (menu.equals(LOGIN)) {
            controller = memlocator.find(LOGIN);
        } else if (menu.equals(MainMenu.RANKING)) {
            controller = memlocator.find(MainMenu.RANKING);
        } else if (menu.equals(Menu2.MYRANKING)) {
            controller = myrank.find(Menu2.MYRANKING);
        }
        else{
            controller = new MainController();
        }
         */
        controller.run(); //common(), show(), prompt()
    }

    @Override
    public void start() {
        while (true) {
            change(MainMenu.MAIN); //첫 화면은 메인 컨트롤러 출력 화면
        }
    }
}
