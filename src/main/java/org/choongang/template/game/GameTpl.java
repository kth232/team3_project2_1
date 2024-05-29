package org.choongang.template.game;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class GameTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("게임 메뉴 선택\n")
                .append(Templates.getInstance().Line())
                .append("1. 혼자하기\n")
                .append("2. 같이하기\n")
                .append("3. 순위보기\n")
                .append("4. 메인메뉴 이동\n");
        return sb.toString();
    }
}
