package org.choongang.game.controllers;

import org.choongang.game.Menu2Router;
import org.choongang.game.Router2;
import org.choongang.game.contents.Menu2;
import org.choongang.global.AbstractController;
import org.choongang.template.Templates;

import java.util.Scanner;


/**
 * 묵찌빠 컨트롤러
 */
public class MjpController extends AbstractController{
    static int comWins;
    static int userRank;
    int userRating = 100;
    static int userWins;
    static int computer; //1, 2, 3     숫자(컴퓨터 출력)
    static String computerChoice;  // 1=묵 , 2=찌, 3=빠      문자 (컴퓨터 출력)
    static String userChoice;  // 묵, 찌, 빠 (유저입력)
    static String restart;  // 게임 다시 시작할건지 (예 or 아무거나)
    static int result;  //1 = 이긴거, 2 = 진거, 3 = 비긴거
    static String choice; // 묵찌빠 예외처리
    int wins = 0; //5판 3승제 만드는 변수...

    @Override
    public void show() {
        Templates.getInstance().render(Menu2.GAMESTART); //  MJP
    }

    @Override
    public void prompt() {

        //가위바위보
        while (true) {
            System.out.println("게임 시작!!");
            userChoice = getUserChoice(sc);
            computerChoice = getComputerChoice();

            System.out.println("컴퓨터: " + computerChoice);

            result = getResult(userChoice, computerChoice);

            while (result == 3) {//비긴경우
                System.out.println("비겼습니다. 다시 할까요?");
                System.out.println(Templates.getInstance().Line());

                userChoice = getUserChoice(sc);
                computerChoice = getComputerChoice();

                System.out.println("컴퓨터 : " + computerChoice);
                result = getResult(userChoice, computerChoice);
            }
            /* 여기 로직은 빼도 될 거 같음 E */
            if (result == 1) {
                System.out.println("이겼습니다");
                System.out.println(Templates.getInstance().Line());
            } else {
                System.out.println("😢패배하였습니다");
                System.out.println(Templates.getInstance().Line());
            }
            /* 여기 로직은 빼도 될 거 같음 S */

            //묵찌빠
            while (true) {
                if (result == 1) {
                    System.out.println("당신의 공격권 입니다!");
                    System.out.println(Templates.getInstance().Line());
                } else { //result == 2
                    System.out.println("🤦‍♂️️컴퓨터의 공격권 입니다🤦‍");
                    System.out.println(Templates.getInstance().Line());
                }

                userChoice = getUserChoice(sc);
                computerChoice = getComputerChoice();

                System.out.println("컴퓨터 : " + computerChoice);

                if (userChoice.equals(computerChoice)) {
                    if (result == 1) {
                        System.out.println("♥♡게임에서 이겼습니다♥♡");
                        System.out.println(Templates.getInstance().Line());
                        userRank = (int) (Math.random() * 37) + 10;
                        userWins++;
                        //userRating += userRank;
                        userRating += 20; //이겼을 때 20점
                    } else {   // result == 2
                        System.out.println("💢💢게임에서 졌습니다😱😱");
                        System.out.println(Templates.getInstance().Line());
                        comWins++;
                        userRating -= 10; //졌을 때 -10점
                    }
                    break;
                } else {   //같지 않을 때 승패 비교
                    result = getResult(userChoice, computerChoice);
                }
            }

            System.out.print("한판더 할까요?(계속하려면 1/그만하려면 2를 입력하세요): ");
            restart = sc.next();
            if (restart.equals("2")) {
                System.out.println("나의 점수는 " + userRating);
                System.out.printf("최종 스코어: 유저 " + userWins + " : PC " + comWins);
                System.out.println();

                if (restart.equals("q") || restart.equals("quit") || restart.equals("exit")) {

                    System.out.println("프로그램을 종료합니다.");
                    System.out.println(Templates.getInstance().doubleLine());
                    System.exit(0); //0: 정상종료/1: 비정상 종료
                }
                try {
                    int m = Integer.parseInt(restart);
                    change(m); //라우터를 통해 메뉴 변경
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("메뉴는 [숫자]로 입력해주세요.");
                }
                Router2 router = Menu2Router.getInstance();
                router.change(Menu2.GAMESTART);
            }
        }
    }

    private void change(int menuNo) {
        Menu2 menu2 = null;
        switch (menuNo) {
            case 2:
                menu2 = Menu2.RULE; // 추후 결과창으로 바꾸기
                break;
            default:
                prompt();
        }
        Menu2Router.getInstance().change(menu2);
    }

//                System.out.println("유저의 점수는 : " + userRank + "! 컴퓨터의 점수는 : " + comRank + " ");
//                if (userRank > comRank) {
//                    System.out.print("♥♡♥♡다으니가 " + (userRank - comRank) + "판 더 이겼어요♥♡♥♡");
//                } else { // 무승부일때도 뜨니깐 문제임
//                    System.out.print("다으니가 " + (comRank - userRank) + "판 더 졌어요ㅠㅠ.. 컴퓨터 바보 멍청이 똥개 해삼 말미잘!");
//                    System.exit(0);
//                }

    //유저 선택
    public static String getUserChoice(Scanner sc) {
        while (true) {
            System.out.print("♡묵, 찌, 빠 중 골라주세요♥ : ");
            choice = sc.next();
            if (choice.equals("묵") || choice.equals("찌") || choice.equals("빠")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. '묵', '찌', '빠' 중에서 다시 골라주세요.");
            }
        }
        return choice;
    }

    //컴퓨터 선택
    public static String getComputerChoice() {
        computer = (int) (Math.random() * 3) + 1;
        switch (computer) {
            case 1:
                return "묵";
            case 2:
                return "찌";
            case 3:
                return "빠";
            default:
                return "";
        }
    }

    public static int getResult(String user, String computer) {
        if (user.equals("묵")) {
            if (computer.equals("묵")) return 3;
            else if (computer.equals("찌")) return 1;
            else return 2;
        } else if (user.equals("찌")) {
            if (computer.equals("묵")) return 2;
            else if (computer.equals("찌")) return 3;
            else return 1;
        } else {
            if (computer.equals("묵")) return 1;
            else if (computer.equals("찌")) return 2;
            else return 3;
        }
    }
}
