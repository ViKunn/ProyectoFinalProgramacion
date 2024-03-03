package presentationEnConsola;

import java.util.Scanner;

public class MenuState {

    private static final Scanner scanner = new Scanner(System.in);

    private static final GameState gameState = new GameState();
    private static final ScoreState scoreState = new ScoreState();

    public static void mainMenu() {

        while (true) {

            System.out.println("===== MAIN MENU =====");
            System.out.println("1. PLAY");
            System.out.println("2. SCORES");
            System.out.println("3. HELP");
            System.out.println("4. EXIT");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    gameState.characterMenu();
                    break;
                case 2:
                    getScores();
                    showScores();
                    break;
                case 3:
                    System.out.println("You just entered the world, may god help you");
                    System.out.println("Hacer este código");
                    break;
                case 4:
                    System.out.println("Exiting game...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    private static void showScores() {
        scoreState.showScore();
    }
    private static void getScores() {
        ScoreState.saveScore(gameState.getScoreOfPlayer());
    }

}