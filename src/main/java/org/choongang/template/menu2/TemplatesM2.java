package org.choongang.template.menu2;

import org.choongang.menu2.contents.Menu2;
import org.choongang.template.Template;

import java.util.HashMap;
import java.util.Map;

public class TemplatesM2 {
    private static TemplatesM2 instance;

    private Map<Menu2, Template> tpls;

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

    public Template find(Menu2 menu2) {
        Template tpl = tpls.get(menu2);
        if (tpl != null) {
            return tpl;
        }
        switch (menu2) {
            case RULE: tpl = new RuleTpl(); break;
            case GAMESTART: tpl = new GameStartTpl(); break;
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
