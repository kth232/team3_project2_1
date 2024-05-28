package org.choongang.global;

public interface Service<T> { //입력받는 데이터가 다양한 자료형->제네릭스, MVC에서 model
    void process(T form); //데이터 처리
}
