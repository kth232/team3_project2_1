package org.choongang.menu2;

import org.choongang.global.Controller;
import org.choongang.menu2.contents.Menu2;
import org.choongang.menu2.controllers.Menu2Controller;
import org.choongang.menu2.controllers.Menu2ControllerLocator;

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
    public void change(Menu2 menu2) {
        ControllerLocatorM2 m2locator = Menu2ControllerLocator.getInstance();

        Controller controller = null;
        switch (menu2){
            case RULE: controller = m2locator.find(Menu2.RULE); break;
            case GAMESTART: controller = m2locator.find(Menu2.GAMESTART); break; //게임시작창으로 넘어가게 해야함 아직 미완
            default: controller = new Menu2Controller(); //메뉴2 메인화면으로
        }
        controller.run();
    }

    @Override
    public void start() {
        while (true) {
            change(Menu2.MAIN2);
        }
    }
}
