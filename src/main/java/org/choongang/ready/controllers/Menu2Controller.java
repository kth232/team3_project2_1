package org.choongang.ready.controllers;

import org.choongang.global.AbstractController;
import org.choongang.ready.Menu2Router;
import org.choongang.ready.contents.Menu2;
import org.choongang.template.menu2.TemplatesM2;

public class Menu2Controller extends AbstractController{
/**
 * 메뉴2 메인 컨트롤러
 */
    @Override
    public void show() {
        TemplatesM2.getInstance().render(Menu2.MAIN2);
    }

    @Override
    public void prompt() {
        System.out.print("MENU 선택!!: ");
        String menu = sc.nextLine();
        try {
            int m = Integer.parseInt(menu);
            change(m); //라우터를 통해 메뉴 변경
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("메뉴는 [숫자]로 입력해주세요.");
        }
    }
    private void change(int menuNo) {
        Menu2 menu2 = null;
        switch (menuNo) {
            case 3:
                menu2 = Menu2.RULE;
                break; //
            case 4:
                menu2 = Menu2.GAMESTART;
                break; //
            default:
                menu2 = Menu2.MAIN2; //메인 화면
        }
        Menu2Router.getInstance().change(menu2);
    }
}
