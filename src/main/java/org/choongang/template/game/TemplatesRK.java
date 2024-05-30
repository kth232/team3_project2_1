package org.choongang.template.game;

import org.choongang.game.contents.Menu2;
import org.choongang.global.contents.MainMenu;
import org.choongang.template.Template;
import org.choongang.template.main.MainTpl;

import java.util.HashMap;
import java.util.Map;

public class TemplatesRK {
    private static TemplatesRK instance;

    private Map<MainMenu, Template> tpls;

    private TemplatesRK() {
        tpls = new HashMap<>();
    }
    public static TemplatesRK getInstance() {
        if (instance == null) {
            instance = new TemplatesRK();
        }
        return instance;
    }

    public void render(MainMenu menu) {
        System.out.println(find(menu).getTpl()); //각 메뉴마다 해당 tpl 가져옴
    }

    public Template find(MainMenu menu) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        switch (menu) {
            case MYRANKING: tpl = new MyRankTpl(); break;
            case RESTART: tpl = new Menu2MainTpl(); break;
            case EXIT: break;
            //추후 수정할 것
        }
        tpls.put(menu, tpl);
        return tpl;
    }
    public String Line() { //라인
        return "------------------------\n";
    }

    public String doubleLine() {
        return "========================\n";
    }

}