package org.choongang.template.game;

public class GameStartTpl implements TemplateM2 {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("게임을 시작합니다.\n");
        sb.append("'5'를 눌러주세요\n");

        sb.append(TemplatesM2.getInstance().Line());
        sb.append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n");

        return sb.toString();
    }
}
