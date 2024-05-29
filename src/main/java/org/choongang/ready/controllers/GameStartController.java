package org.choongang.ready.controllers;

import org.choongang.global.AbstractController;
import org.choongang.ready.contents.Menu2;
import org.choongang.template.menu2.TemplatesM2;

public class GameStartController extends AbstractController {
    @Override
    public void show() {
        TemplatesM2.getInstance().render(Menu2.GAMESTART);
    }
}
