package org.choongang.global;

import org.choongang.global.constants.MainMenu;

public interface ServiceLocator { //서비스를 찾아주는 인터페이스, singleton pattern
    Service find(MainMenu mainMenu);
} // 서비스 관리
