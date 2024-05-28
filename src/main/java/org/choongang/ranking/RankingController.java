package org.choongang.ranking;

import org.choongang.global.AbstractController;
import org.choongang.global.contents.Menu;
import org.choongang.template.Templates;

public class RankingController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.RANKING);
    }
    

}
