package org.choongang.template.game;


public class Menu2MainTpl implements TemplateM2{
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000); //버퍼 생성
        sb.append("BEFORE GAME START..\n")
                .append("3. GAME EXPLAIN\n")
                .append("4. GAME START!!\n")
                .append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n")
                .append(TemplatesM2.getInstance().Line());

        return sb.toString();
    }
}