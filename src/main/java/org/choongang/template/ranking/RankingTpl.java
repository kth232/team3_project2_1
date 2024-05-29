package org.choongang.template.ranking;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

public class RankingTpl implements Template {
    //랭킹 데이터 문자열로 반환
    private Supplier<String> hook;
    //선택기능
    public void addHook(Supplier<String> hook){
        this.hook = hook;
    }

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("✨✨명예의 전당 묵찌빠 TOP 3✨✨\n");
        sb.append(Templates.getInstance().Line());
        if (hook != null) {
            sb.append(hook.get());
        }

        return sb.toString();
    }
}
