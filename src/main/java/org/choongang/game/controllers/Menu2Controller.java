package org.choongang.game.controllers;

import org.choongang.global.AbstractController;
import org.choongang.game.Menu2Router;
import org.choongang.game.contents.Menu2;
import org.choongang.template.Templates;
import org.choongang.template.game.TemplatesM2;

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
            System.err.println("메뉴는 [숫자]로 입력해주세요.\n3번과 4번 중 선택해주세요.");
            Menu2Router.getInstance().change(Menu2.MAIN2);
        }
    }
    private void change(int menuNo) throws Exception {
        Menu2 menu2 = null;
        switch (menuNo) {
            case 3:
                menu2 = Menu2.RULE;
                break; //
            case 4:
                menu2 = Menu2.GAMESTART;
                break; //
            default:
                throw new Exception();
        }
        Menu2Router.getInstance().change(menu2);
    }
}
