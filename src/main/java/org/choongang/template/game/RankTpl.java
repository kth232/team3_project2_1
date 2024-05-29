package org.choongang.template.game;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RankTpl implements Template {

    private Supplier<String> hook;

    public void addHook(Supplier<String> hook) {
        this.hook = hook;
    }

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("순위보기\n");
        sb.append(Templates.getInstance().line());
        if(hook != null) {
            sb.append(hook.get());
        }
        return sb.toString();
    }
}
