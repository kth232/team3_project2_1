package org.choongang.ready.controllers;

import org.choongang.global.AbstractController;
import org.choongang.ready.Menu2Router;
import org.choongang.ready.contents.ReadyMenu;
import org.choongang.template.Templates;
import org.choongang.template.ready.TemplatesM2;

public class Menu2Controller extends AbstractController{
/**
 * 메뉴2 메인 컨트롤러
 */
    @Override
    public void show() {
        TemplatesM2.getInstance().render(ReadyMenu.MAIN2);
    }

    @Override
    public void prompt() {
        System.out.print("MENU 선택!!: ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("게임을 종료합니다.");
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
    }
    private void change(int menuNo) {
        ReadyMenu readyMenu = null;
        switch (menuNo) {
            case 1:
                readyMenu = ReadyMenu.RULE;
                break; //
            case 2:
                readyMenu = ReadyMenu.GAMESTART;
                break; //
            default:
                //readyMenu = ReadyMenu.MAIN2; //메인 화면
                System.err.println("1번과 2번 중 입력해주세요.");
                prompt();
        }
        Menu2Router.getInstance().change(readyMenu);

    }
}
