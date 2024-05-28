package org.choongang.menu2;

import org.choongang.menu2.contents.Menu2;

public class Menu2Router implements Router2 {
    private static Router2 instance;
    private Menu2Router(){}
    public static Router2 getInstance(){
        if(instance == null){
            instance = new Menu2Router();
        }
        return instance;
    }
    @Override
    public void change(Menu2 menu2) {

    }

    @Override
    public void start() {

    }
}
