package org.choongang.template;

import org.choongang.global.contents.Menu;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.member.MypageTpl;

import java.util.HashMap;
import java.util.Map;

public class Templates {
    private static Templates instance;

    private Map<Menu, Template> tpls;

    private Templates() {
        tpls = new HashMap<>();
    }
    public static Templates getInstance() {
        if (instance == null) {
            instance = new Templates();
        }
        return instance;
    }

    public void render(Menu menu) {
        System.out.println(find(menu).getTpl()); //각 메뉴마다 해당 tpl 가져옴
    }

    public Template find(Menu menu) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        switch (menu) {
            case JOIN: tpl = new JoinTpl(); break;
            case LOGIN: tpl = new LoginTpl(); break;
            case MYPAGE: tpl = new MypageTpl(); break;
            default: tpl = new MainTpl();
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
