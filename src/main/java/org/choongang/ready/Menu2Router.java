package org.choongang.ready;

import org.choongang.global.Controller;
import org.choongang.ready.contents.ReadyMenu;
import org.choongang.ready.controllers.Menu2Controller;
import org.choongang.ready.controllers.Menu2ControllerLocator;

public class Menu2Router implements Router2 {
    private static Router2 instance;

    private Menu2Router() {}

    public static Router2 getInstance(){
        if(instance == null){
            instance = new Menu2Router();
        }
        return instance;
    }
    @Override
    public void change(ReadyMenu readyMenu) {
        ControllerLocatorM2 m2locator = Menu2ControllerLocator.getInstance();

        Controller controller = null;
        switch (readyMenu){
            case RULE: controller = m2locator.find(ReadyMenu.RULE); break;
            case GAMESTART: controller = m2locator.find(ReadyMenu.GAMESTART); break; //게임시작창으로 넘어가게 해야함 아직 미완
            default: controller = new Menu2Controller(); //메뉴2 메인화면으로
        }
        controller.run();
    }

    @Override
    public void start() {
        while (true) {
            change(ReadyMenu.MAIN2);
        }
    }
}
