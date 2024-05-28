package org.choongang.global;

import org.choongang.global.contents.Menu;

/**
 * 사용자가 입력한 메뉴 번호, 문구->해당하는 컨트롤러로 연결
 */
public interface Router {
    void change(Menu menu);
    //enum 상수를 넣으면 해당 메뉴로 연결
    void start();
}
