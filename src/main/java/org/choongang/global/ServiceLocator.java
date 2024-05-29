package org.choongang.global;

public interface ServiceLocator { //서비스를 찾아주는 인터페이스, singleton pattern
    Service find(Menu menu);
}
