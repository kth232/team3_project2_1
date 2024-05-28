package org.choongang.template.menu2;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class RuleTpl implements TemplateM2 {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("🤍게임 설명🤍\n");
        sb.append("5판 3승제를 원칙으로 합니다.\n");
        sb.append("승리 시 +20point, 패배 시 -10point를 획득합니다.\n");
        sb.append("명예의 전당에 도전하세요~\n");
        sb.append(Templates.getInstance().Line());

        return sb.toString();
    }
}
