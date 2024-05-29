package org.choongang.template.ready;

public class GameStartTpl implements TemplateM2 {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("\n___ ____ ___ GAME START___ ___ ___\n\n")
                .append("게임을 시작합니다.\n")
                .append("s키를 눌러주세요\n").append(TemplatesM2.getInstance().Line())
                .append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n");

        return sb.toString();
    }
}
