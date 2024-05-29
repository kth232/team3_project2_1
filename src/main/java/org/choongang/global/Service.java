package org.choongang.global;

public interface Service<T> { //입력받는 데이터가 다양한 자료형->제네릭스, MVC에서 model
    default void process(T form){}; //데이터 처리 - 필요할때만 정의하는 디폴트메서드로 변경!
    default T process() { //매개변수x, 반환값이 있는 형태로 정의! T
        return null;
    }
}
