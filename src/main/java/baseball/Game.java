package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static baseball.Constants.*;

public class Game {
    // TODO

    Player player ;
    Referee referee;


    Game(Player player, Referee referee){
        this.player = player;
        this.referee = referee;
    }

    /*
     * 게임을 초기화한다. (맨 처음에 시작할 수 있도록!)
     */
    public void run(){
        while (true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            ArrayList<Integer> gameNumList = getRandomNumbers();
            boolean game = newGameStart(gameNumList);
            if (!game) break;
        }
    }


    /*
     * 새로운 게임 할당 로직
     */
    public boolean newGameStart(ArrayList<Integer> gameNumList){
        while (true){
            //player에게 입력을 받는다. -> Player 객체 사용
            requestNumbers();
            ArrayList<Integer> playerNumList = player.getNumbers();

            // numList와 player 값을 비교 -> Referee 객체 사용
            int[] result = referee.compare(gameNumList, playerNumList);
            displayResult(result);
            if (isFULLStrike(result)) {
                fullStrike();
                int continueNum = player.getNumberForContinue();
                if (continueNum == 2) {
                    return false; //끝냅니다.
                }
                return true; //한 번 더 합니다.
            }
        }
    }

    /*
     * Random 값을 추출한다.
     */
    public ArrayList<Integer> getRandomNumbers(){
        ArrayList<Integer> numList = new ArrayList<>();
        while (numList.size() < GAME_RANDOM_COUNT){
            int randomNum = Randoms.pickNumberInRange(GAME_RANDOM_NUM_MIN,GAME_RANDOM_NUM_MAX);
            if (!numList.contains(randomNum)){
                numList.add(randomNum);
            }
        }
        System.out.println("numList "+ numList);
        return numList;
    }



    /*
     * User에게 입력을 요구하기 위한 display
     */

    public void requestNumbers(){
        System.out.println("숫자를 입력해주세요 : ");
    }


    public void fullStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

    public boolean isFULLStrike(int[] result){
        return result[0]==FULL_STRIKE;
    }

    public void displayResult(int[] result){
        int strike = result[0];
        int ball = result[1];

        if (strike>0 && ball>0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        } else if (strike>0){
            System.out.println(strike+"스트라이크");
        } else if (strike>0){
            System.out.println(ball+"볼");
        } else{
            System.out.println("낫싱");
        }
    }

}
