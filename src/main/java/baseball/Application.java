package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        /*
         * 변경 가능한 부분에 대해 고민 !!
         */

        Game game = new Game(new Player(), new Referee());
        game.run();
    }
}
