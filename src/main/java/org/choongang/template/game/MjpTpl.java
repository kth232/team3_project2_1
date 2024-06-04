package org.choongang.template.game;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class MjpTpl implements Template{
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("묵찌빠\n");
        sb.append(Templates.getInstance().Line());

        return sb.toString();
    }
}
