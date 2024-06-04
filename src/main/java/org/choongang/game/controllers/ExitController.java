package org.choongang.game.controllers;

import org.choongang.global.AbstractController;
import org.choongang.template.Templates;

public class ExitController extends AbstractController {
    public void prompt() {
        System.out.print("MENU 선택: ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.out.println(Templates.getInstance().doubleLine());
            System.exit(0); //0: 정상종료/1: 비정상 종료
        }
    }

    @Override
    public void show() {
    }
}
