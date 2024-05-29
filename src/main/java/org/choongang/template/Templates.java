package org.choongang.template;

import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.game.GameTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.member.MypageTpl;

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

    public void render(Menu menu) {
        render(menu, null);
    }

    public void render(Menu menu, Supplier<String> hook) {

        System.out.println(find(menu, hook).getTpl());
    }

    public Template find(Menu menu, Supplier<String> hook) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        /*
        if (menu instanceof SubMenu) {

            SubMenu subMenu = (SubMenu) menu;
            switch(subMenu) {
                case ALONE:
                case TOGETHER:
                case RANKING: tpl = new RankTpl(); break;
            }
        }
        */
        else {

            MainMenu mainMenu = (MainMenu)menu;
            switch (mainMenu) {
                case JOIN:
                    tpl = new JoinTpl();
                    break;
                case LOGIN:
                    tpl = new LoginTpl();
                    break;
                case MYPAGE:
                    tpl = new MypageTpl();
                    break;
                case GAME:
                    tpl = new GameTpl();
                    break;
                default:
                    tpl = new MainTpl();
            }
        }

        if (hook != null) {
            tpl.addHook(hook);
        }

        tpls.put(menu, tpl);

        return tpl;
    }

    public String line() {
        return "-----------------------------------\n";
    }

    public String doubleLine() {
        return "===================================\n";
    }
}