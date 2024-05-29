package org.choongang.template;


import com.sun.tools.javac.Main;
import org.choongang.game.contents.Menu2;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.ranking.RankingTpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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

    // render 메서드 오버로드 (hook이 없는 경우 사용할 수 있게)
    public void render(Menu menu){
        render(menu, null);
    }

    public void render(Menu menu, Supplier<String> hook) {
        System.out.println(find(menu, hook).getTpl()); //각 메뉴마다 해당 tpl 가져옴
    }

    public Template find(Menu menu, Supplier<String> hook) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        MainMenu mainMenu = (MainMenu) menu;

        switch (mainMenu) {
            case JOIN: tpl = new JoinTpl(); break;
            case LOGIN: tpl = new LoginTpl(); break;
            case RANKING: tpl = new RankingTpl(); break;
            default: tpl = new MainTpl();
        }
        if(hook != null){
        tpl.addHook(hook);
        }

        tpls.put(menu, tpl);
        return tpl;
    }
    public String Line() { //라인
        return "-----------------------------------------\n";
    }

    public String doubleLine() {
        return "=========================================\n";

    }

    public void render(Menu2 menu2) {
    } //수정중
}
