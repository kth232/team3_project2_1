package org.choongang.main;

import org.choongang.game.controllers.RankingControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

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
    public void change(MainMenu mainMenu) {

        ControllerLocator ranklocator = RankingControllerLocator.getInstance();
        ControllerLocator restartlocator = RankingControllerLocator.getInstance();
        ControllerLocator exitlocator = RankingControllerLocator.getInstance();


        Controller controller = null;
        switch (mainMenu) {
            case MYRANKING: controller = ranklocator.find(MainMenu.MYRANKING); break;
            case RESTART: controller = ranklocator.find(MainMenu.GAME); break; // 변경
            case EXIT: controller = exitlocator.find(MainMenu.EXIT); break;
            default: controller = new MainController();
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
