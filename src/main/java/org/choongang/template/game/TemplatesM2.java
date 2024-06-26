package org.choongang.template.game;

import org.choongang.game.contents.Menu2;

import java.util.HashMap;
import java.util.Map;

public class TemplatesM2 {
    private static TemplatesM2 instance;

    private Map<Menu2, TemplateM2> tpls;

    private TemplatesM2() {
        tpls = new HashMap<>();
    }
    public static TemplatesM2 getInstance() {
        if (instance == null) {
            instance = new TemplatesM2();
        }
        return instance;
    }

    public void render(Menu2 menu2) {
        System.out.println(find(menu2).getTpl()); //각 메뉴마다 해당 tpl 가져옴
    }

    public TemplateM2 find(Menu2 menu2) {
        TemplateM2 tpl = tpls.get(menu2);
        if (tpl != null) {
            return tpl;
        }
        switch (menu2) {
            case RULE: tpl = new RuleTpl(); break;
            case GAMESTART: tpl = new GameStartTpl(); break;
            case PLAYGAME: tpl = new MjpTpl(); break;
            default: tpl = new Menu2MainTpl();
        }
        tpls.put(menu2, tpl);
        return tpl;
    }
    public String Line() { //라인
        return "------------------------\n";
    }

    public String doubleLine() {
        return "========================\n";
    }

}