package org.choongang.template.main;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000); //버퍼 생성
        sb.append("MAIN MENU\n")
            .append("1. SIGN UP\n")
            .append("2. LOGIN\n")
            .append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n")
            .append(Templates.getInstance().Line());
        
        return sb.toString();
    }
}
