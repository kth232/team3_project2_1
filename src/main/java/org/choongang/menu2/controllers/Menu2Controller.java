package org.choongang.menu2.controllers;

import org.choongang.global.AbstractController;
import org.choongang.menu2.contents.Menu2;
import org.choongang.template.Templates;
import org.choongang.template.menu2.TemplatesM2;

public class Menu2Controller extends AbstractController {
    @Override
    public void show() {
        TemplatesM2.getInstance().render(Menu2.MAIN2);
    }
}
