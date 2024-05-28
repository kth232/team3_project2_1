package org.choongang.template.member;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class RankingTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("✨✨명예의 전당 묵찌빠 TOP 3✨✨\n")
                .append(Templates.getInstance().doubleLine());
        return sb.toString();
    }
}
