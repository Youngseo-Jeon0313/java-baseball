package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static baseball.Constants.PLAYER_INPUT_COUNT;

import static baseball.Constants.*;

public class Player {

    /*
     * player 가 숫자 3개를 입력한다.
     */
    public ArrayList<Integer> getNumbers() {
        String input = Console.readLine(); // 사용자의 입력 받음

        if (checkNumForm(input, PLAYER_INPUT_COUNT)) {
            ArrayList<Integer> playerNumList = new ArrayList<>();

            for (char word : input.toCharArray()) {
                // 입력된 String 형태를 각각 int로 변환하여 ArrayList에 추가
                int num = Character.getNumericValue(word);
                playerNumList.add(num);
            }
            return playerNumList;
        }
        throw new IllegalArgumentException();
    }

    private boolean checkNumForm(String input, int count){
        String regex = getInputRegex(GAME_RANDOM_NUM_MIN, GAME_RANDOM_NUM_MAX, GAME_RANDOM_COUNT);
        return input.length() == count && input.matches(regex);
    }

    /*
     * player 가 게임을 계속할지 말지에 대한 입력한다.
     */
    public int getNumberForContinue() {
        String input = Console.readLine();
        if (checkNumFormForContinue(input, PLAYER_RE_INPUT_COUNT)){
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException();
    }

    private boolean checkNumFormForContinue(String input, int count){
        String regex = getInputRegex(GAME_RESTART_NUM, GAME_FINISH_NUM, count);
        return input.length() == count && input.matches(regex);
    }


    public String getInputRegex(int minNum, int maxNum, int count){
        return String.format("^[%d-%d]{%d}$", minNum, maxNum, count);
    }

}
