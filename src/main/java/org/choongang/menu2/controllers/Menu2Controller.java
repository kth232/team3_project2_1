package org.choongang.menu2.controllers;

import org.choongang.global.AbstractController;
import org.choongang.menu2.contents.Menu2;
import org.choongang.template.Templates;

public class Menu2Controller extends AbstractController{
/**
 * 메뉴2 메인 컨트롤러
 */
    @Override
    public void show() {
        Templates.getInstance().render(Menu2.MAIN2);
    }
}
