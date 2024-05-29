package org.choongang.ready.controllers;

import org.choongang.global.AbstractController;
import org.choongang.ready.contents.ReadyMenu;
import org.choongang.template.ready.TemplatesM2;

public class GameStartController extends AbstractController {
    @Override
    public void show() {
        TemplatesM2.getInstance().render(ReadyMenu.GAMESTART);
    }
}
