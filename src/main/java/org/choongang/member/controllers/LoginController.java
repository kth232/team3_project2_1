package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.LOGIN);
    }

    @Override
    public void prompt() {
        //아이디와 비번이 있을 때만 넘어감, 입력값 없으면 입력 화면 반복
        String userId = promptWithValidation("ID: ", s -> !s.isBlank());
        String userPw = promptWithValidation("PW: ", s -> !s.isBlank());

        //로그인 처리, 데이터 클래스-값을 객체에 담음 -> 객체에 담아서 서비스로 보냄(검증을 위해)
        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .build(); // 어떤 값이 어떤 컬럼에 들어가는지 볼 수 있음
        // DTO atabase에서 Data를 얻어 Service나 Controller 등으로 보낼 때 사용하는 객체

        Router router = MainRouter.getInstance();
        
        try {
            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
            service.process(form);

            //로그인 성공 시->메인 화면으로 이동
            router.change(MainMenu.MAIN);
        } catch (RuntimeException e) {
            //로그인 실패 시 -> 로그인 화면으로 이동
            System.err.println(e.getMessage());
            router.change(MainMenu.LOGIN);
        }
    } //prompt 재정의
}
