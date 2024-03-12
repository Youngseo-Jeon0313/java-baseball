package baseball;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static baseball.Constants.GAME_RANDOM_COUNT;

public class Referee {

    /*
     * 스트라이크, 볼, 낫싱을 판단한다.
     */
    public int[] compare(ArrayList<Integer> gameNumList, ArrayList<Integer> playerNumList){
        int strike = 0;
        int ball = 0;

        //같은 위치에 있는지 확인
        for (int i=0; i<GAME_RANDOM_COUNT; i++){
            for (int j=0; j<GAME_RANDOM_COUNT; j++){
                if (gameNumList.get(i)==playerNumList.get(j) && i==j){
                    strike +=1;
                }
                if (gameNumList.get(i)==playerNumList.get(j) && i!=j){
                    ball +=1;
                }
            }
        }
        return new int[]{strike, ball};
    }
}
