package org.choongang.game.services;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.contents.MainMenu;

public class MyRankServiceLocator extends AbstractController {
    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new org.choongang.member.services.MemberServiceLocator();
        }

        return instance;
    }

    @Override
    public Service find(MainMenu menu) {
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }

        MainMenu gameMenu = (MainMenu) menu;

        switch (gameMenu) {
            case MYRANKING:
                service = new MyPointLogService();
                break;
            case RESTART:
                service = new MyPointLogService();
                break;
            case EXIT:
            default:
                service = new MyPointLogService();
                break;
        }

        return service;
    }
}
