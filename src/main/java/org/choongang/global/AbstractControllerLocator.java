package org.choongang.global;

import java.util.HashMap;
import java.util.Map;

;

public abstract class AbstractControllerLocator implements ControllerLocator {

    //인스턴스 생성은 각 controllerLocator 에서 private 으로 ~!

    protected Map<Menu,Controller> controllers;

    protected  AbstractControllerLocator() {
        controllers = new HashMap<>();
    }

}