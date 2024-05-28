package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.contents.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

import java.util.function.Predicate;

/**
 * 회원가입 컨트롤러
 */
public class JoinController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.JOIN);
    }

    @Override
    public void prompt() {
        String userId = promptWithValidation("ID(6자리 이상): ", s -> s.length() >= 6);
        String userPw = promptWithValidation("PW(8자리 이상): ", s -> s.length() >= 8);
        String confirmPw = promptWithValidation("PW 확인: ", s -> {
            boolean match = s.equals(userPw);
            if (!match) {
                System.err.println("\n비밀번호가 일치하지 않습니다.");
            }
            return match;
        });
        String userNm = promptWithValidation("USER NAME: ", s -> !s.isBlank());
        //회원가입 처리, 데이터 클래스-값을 객체에 담음
        RequestJoin form = RequestJoin.builder()
                .userId(userId)
                .userPw(userPw)
                .confirmPw(confirmPw)
                .userNm(userNm)
                .build();

        Router router = MainRouter.getInstance();
        
        try {
            Service service = MemberServiceLocator.getInstance().find(Menu.JOIN);
            service.process(form);

            //회원가입 성공 시 -> 로그인 화면으로 이동
            router.change(Menu.LOGIN);
        } catch (RuntimeException e){
            //회원가입 실패 시 -> 회원가입 화면으로 이동
            System.err.println(e.getMessage());
            router.change(Menu.JOIN);
        }
    } //prompt 재정의
}
