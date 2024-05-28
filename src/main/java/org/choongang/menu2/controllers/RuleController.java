package org.choongang.menu2.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.menu2.Menu2Router;
import org.choongang.menu2.Router2;
import org.choongang.menu2.contents.Menu2;
import org.choongang.template.Templates;
import org.choongang.template.menu2.TemplatesM2;

/**
 * 게임설명 컨트롤러
 */
public class RuleController extends AbstractController {
    @Override
    public void show() { //모델과 뷰 연결 및 동작
        TemplatesM2.getInstance().render(Menu2.RULE);
    }

    @Override
    public void prompt() {
        Router2 router = Menu2Router.getInstance();
        router.change(Menu2.GAMESTART);
        //추후 게임화면으로 넘어가는 라우터 연결
    } //prompt 재정의
}
