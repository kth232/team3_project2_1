package org.choongang.global;

public interface ControllerLocator {
    //컨트롤러 찾아주는 인터페이스
    Controller find(Menu menu); //뭐가 올지 모르기 때문에 다형성 활용
}
