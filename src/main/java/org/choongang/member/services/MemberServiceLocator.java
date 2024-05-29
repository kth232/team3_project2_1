package org.choongang.member.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.contents.MainMenu;

public class MemberServiceLocator extends AbstractServiceLocator {
    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new MemberServiceLocator();
        }
        return instance;
    }

    @Override
    public Service find(MainMenu mainMenu) { //singleton pattern
        Service service = services.get(mainMenu);
        if (service != null){
            return service;
        }
        switch (mainMenu) {
            case JOIN: service = new JoinService(); break;
            case LOGIN: service = new LoginServie(); break;
            default:
        }
        return service;
    }
}
