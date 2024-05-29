package org.choongang.template.ready;

public class RuleTpl implements TemplateM2 {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("🤍게임 설명🤍\n");
        sb.append("5판 3승제를 원칙으로 기본 점수는 100점입니다.\n");
        sb.append("승리 시 +20 point, 패배 시 -10 point를 획득합니다.\n");
        sb.append("명예의 전당에 도전하세요~\n");
        sb.append("게임을 시작하려면 '2'를 입력하세요\n");

        sb.append(TemplatesM2.getInstance().Line());
        sb.append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n");

        return sb.toString();
    }
}
