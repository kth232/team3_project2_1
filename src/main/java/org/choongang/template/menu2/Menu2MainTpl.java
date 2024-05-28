package org.choongang.template.menu2;


import org.choongang.template.Template;
import org.choongang.template.Templates;

public class Menu2MainTpl implements TemplateM2{
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000); //버퍼 생성
        sb.append("BEFORE GAME START..\n")
                .append("1. GAME EXPLAIN\n")
                .append("2. GAME START!!\n")
                .append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n")
                .append(Templates.getInstance().Line());

        return sb.toString();
    }
}
