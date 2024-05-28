package org.choongang.member.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.contents.Menu;

import java.util.HashMap;
import java.util.Map;

public class MemberControllerLocator implements ControllerLocator {
    private static ControllerLocator instance; //singleton pattern
    
    private Map<Menu, Controller> controllers;
    
    private MemberControllerLocator() {
        controllers = new HashMap<>();
    } //생성자 한정
    
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
        switch (menu) {
            case JOIN: controller = new JoinController(); break;
            default:  controller = new LoginController();
            //추후 컨트롤러 추가
        }
        controllers.put(menu, controller); //기존 것이 있으면 기존 것 사용, 없으면 새로 추가
        return controller;
    } 
}
