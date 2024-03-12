package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {
    // TODO

    Player player ;
    Referee referee;


    Game(Player player, Referee referee){
        this.player = player;
        this.referee = referee;
    }

    /*
     * 게임을 초기화한다. (시작할 수 있도록!)
     */
    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            ArrayList<Integer> numList = getRandomNumbers();

            requestNumbers();
            //player에게 입력을 받는다. -> Player 객체 사용

            // numList와 player 값을 비교 -> Referee 객체 사용
        }
    }



    /*
     * Random 값을 추출한다.
     */
    public ArrayList<Integer> getRandomNumbers(){
        ArrayList<Integer> numList = new ArrayList<>();
        while (numList.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1,9);
            if (!numList.contains(randomNum)){
                numList.add(randomNum);
            }
        }
        return numList;
    }



    /*
     * User에게 입력을 요구한다.
     */

    public void requestNumbers(){
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void requestGameContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

    public void threeStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
    }


}
