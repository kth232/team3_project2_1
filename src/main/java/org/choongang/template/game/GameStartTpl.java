package org.choongang.template.game;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class GameStartTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("게임을 시작합니다.\n");
        sb.append("'5'를 눌러주세요\n");

        sb.append(Templates.getInstance().Line());
        sb.append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n");

        return sb.toString();
    }
}
