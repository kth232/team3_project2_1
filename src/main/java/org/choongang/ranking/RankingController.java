package org.choongang.ranking;

import com.sun.tools.javac.Main;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.configs.DBConn;
import org.choongang.global.contents.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.template.Templates;

public class RankingController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.RANKING);
    }

}
