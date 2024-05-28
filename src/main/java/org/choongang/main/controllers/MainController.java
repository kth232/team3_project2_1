package org.choongang.main.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.contents.Menu;
import org.choongang.template.Templates;

/**
 * 메인 컨트롤러
 */
public class MainController extends AbstractController {
    @Override
    public String show() {
        Templates.getInstance().render(Menu.MAIN);
        return null;
    }
}
