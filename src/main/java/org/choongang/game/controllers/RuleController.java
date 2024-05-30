package org.choongang.game.controllers;

import org.choongang.global.AbstractController;
import org.choongang.game.Menu2Router;
import org.choongang.game.Router2;
import org.choongang.game.contents.Menu2;
import org.choongang.template.Templates;
import org.choongang.template.game.TemplatesM2;

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
        System.out.print("게임시작(4) or 종료(q): ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.out.println(Templates.getInstance().doubleLine());
            System.exit(0); //0: 정상종료/1: 비정상 종료
        }
        try {
            int m = Integer.parseInt(menu);
            change(m); //라우터를 통해 메뉴 변경
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("메뉴는 [숫자]로 입력해주세요.");
        }

        Router2 router = Menu2Router.getInstance();
        router.change(Menu2.GAMESTART);
        //추후 게임화면으로 넘어가는 라우터 연결
    } //prompt 재정의
    private void change(int menuNo) {
        Menu2 menu2 = null;
        switch (menuNo) {
            case 4:
                menu2 = Menu2.GAMESTART;
                break; //
            default:
                prompt();
        }
        Menu2Router.getInstance().change(menu2);
    }
}
