package org.choongang.menu2;

import org.choongang.global.Router;
import org.choongang.global.contents.Menu;
import org.choongang.global.contents.Menu2;

public class Menu2Router implements Router {
    private static Router instance;
    private Menu2Router(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new Menu2Router();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {

    }

    @Override
    public void start() {

    }
}
