package org.choongang.template.ready;


public class Menu2MainTpl implements TemplateM2{
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000); //버퍼 생성
        sb.append("\n___ ____ ___ BEFORE GAME START___ ___ ___\n\n")
                .append("1. GAME EXPLAIN (⊙_⊙)？\n")
                .append("2. GAME START!! ~o( =∩ω∩= )m\n")
                .append(TemplatesM2.getInstance().Line())
                .append("* 종료하려면 q/quit/exit 중 하나를 입력하세요.\n")
                .append(TemplatesM2.getInstance().Line());

        return sb.toString();
    }
}
