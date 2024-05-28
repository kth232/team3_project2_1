package org.choongang.member.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.contents.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.member.services.RankingService;
import org.choongang.template.Templates;

import java.io.IOException;

public class RankingController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.RANKING); }

}
