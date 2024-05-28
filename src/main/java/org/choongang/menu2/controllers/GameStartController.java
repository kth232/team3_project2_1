package org.choongang.menu2.controllers;

import org.choongang.global.AbstractController;
import org.choongang.menu2.contents.Menu2;
import org.choongang.template.Templates;

public class GameStartController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu2.GAMESTART);
    }
}
