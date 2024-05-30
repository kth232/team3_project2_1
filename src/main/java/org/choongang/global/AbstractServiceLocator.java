package org.choongang.global;


import org.choongang.global.constants.MainMenu;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLocator implements ServiceLocator{
    protected static ServiceLocator instance; //변수만 공유

    protected Map<Menu, Service> services;

    protected AbstractServiceLocator() {
        services = new HashMap<>();
    }
}