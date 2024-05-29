package org.choongang.template.ready;

import org.choongang.ready.contents.ReadyMenu;

import java.util.HashMap;
import java.util.Map;

public class TemplatesM2 {
    private static TemplatesM2 instance;

    private Map<ReadyMenu, TemplateM2> tpls;

    private TemplatesM2() {
        tpls = new HashMap<>();
    }
    public static TemplatesM2 getInstance() {
        if (instance == null) {
            instance = new TemplatesM2();
        }
        return instance;
    }

    public void render(ReadyMenu readyMenu) {
        System.out.println(find(readyMenu).getTpl()); //각 메뉴마다 해당 tpl 가져옴
    }

    public TemplateM2 find(ReadyMenu readyMenu) {
        TemplateM2 tpl = tpls.get(readyMenu);
        if (tpl != null) {
            return tpl;
        }
        switch (readyMenu) {
            case RULE: tpl = new RuleTpl(); break;
            case GAMESTART: tpl = new GameStartTpl(); break;
            default: tpl = new Menu2MainTpl();
        }
        tpls.put(readyMenu, tpl);
        return tpl;
    }
    public String Line() { //라인
        return "-----------------------------------------\n";
    }

    public String doubleLine() {
        return "=========================================\n";
    }

}
