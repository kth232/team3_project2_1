package org.choongang.ready.controllers;

import org.choongang.global.AbstractController;
import org.choongang.ready.Menu2Router;
import org.choongang.ready.Router2;
import org.choongang.ready.contents.ReadyMenu;
import org.choongang.template.Templates;
import org.choongang.template.ready.TemplatesM2;

/**
 * 게임설명 컨트롤러
 */
public class RuleController extends AbstractController {
    @Override
    public void show() { //모델과 뷰 연결 및 동작
        TemplatesM2.getInstance().render(ReadyMenu.RULE);
    }

    @Override
    public void prompt() {
        int menuNo = 0;
        System.out.print("게임시작(2) or 종료(q): ");
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

        Router2 router = Menu2Router.getInstance();
        router.change(ReadyMenu.GAMESTART);
        //추후 게임화면으로 넘어가는 라우터 연결
    } //prompt 재정의
    private void change(int menuNo) {
        ReadyMenu readyMenu = null;
        switch (menuNo) {
            case 2:
                readyMenu = ReadyMenu.GAMESTART;
                break; //
            default:
                prompt();
        }
        Menu2Router.getInstance().change(readyMenu);
    }
}
