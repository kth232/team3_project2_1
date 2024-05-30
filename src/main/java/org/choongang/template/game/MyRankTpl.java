package org.choongang.template.game;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

public class MyRankTpl implements Template{

    private Supplier<String> hook;

    public void addHook(Supplier<String> hook){
        this.hook = hook;
    }

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("나의 랭킹보기\n");
        sb.append(Templates.getInstance().Line());
        if (hook != null) {
            sb.append(hook.get());
        }

        return sb.toString();
    }
}