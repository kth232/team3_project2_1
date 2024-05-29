package org.choongang.template;

import java.util.function.Supplier;

public interface Template {
    String getTpl();

    //필요할 때만 정의하여 쓰는 메서드 default 메서드
    default void addHook(Supplier<String> supplier){}
}
