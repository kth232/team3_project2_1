package org.choongang.template.main;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000); //버퍼 생성
        sb.append("<도전! 묵찌빠 게임!>\n")
            .append("1. 회원가입\n")
            .append("2. 로그인\n")
            .append("3. 🥇묵찌빠 명예의 전당🏆\n")
            .append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n")
            .append(Templates.getInstance().Line());
        
        return sb.toString();
    }
}
