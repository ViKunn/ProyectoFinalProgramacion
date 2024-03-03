package presentationEnConsola;

import business.entities.Direction;
import business.GameLogic;
import business.Score;

import java.util.ArrayList;
import java.util.Scanner;

public class GameState {
    private static final Scanner scanner = new Scanner(System.in);
    private static GameLogic gameLogic = new GameLogic();
    ArrayList<Score> lisScoreReturn = new ArrayList<>();

    public void characterMenu() {
        System.out.println("1. Chocolate Ice Cream");
        System.out.println("2. Strawberry Ice Cream");
        System.out.println("3. Vanilla Ice Cream");
        System.out.println("4. Fernando");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You have chosen chocolate ice cream");
                menuLevel();
                break;
            case 2:
                System.out.println("You have chosen strawberry ice cream");
                menuLevel();
                break;
            case 3:
                System.out.println("You have chosen vanilla ice cream");
                menuLevel();
                break;
            case 4:
                System.out.println("You have chosen Fernando");
                menuLevel();
                break;

            default:
                System.out.println("Invalid choice, defaulting to chocolate ice cream");
                break;
        }

    }

    public void menuLevel() {

        System.out.println("****** LEVEL MENU ******");
        System.out.println("1. LEVEL 1");
        System.out.println("2. LEVEL 2");
        System.out.println("Select a Level: ");

        int number = scanner.nextInt();

        switch (number) {
            case 1:
                // Initialize and return level 1 GameLogic
                playGame(1); break;
            case 2:
                // Initialize and return level 2 GameLogic
                playGame(2); break;
            default:
                System.out.println("There are no more levels.");
        }

    }

    public void playGame(int levelNumber) {

        System.out.println("Game started - Level " + levelNumber);

        gameLogic = new GameLogic();
        gameLogic.startLevel(levelNumber);
        gameLogic.starThread();

        // gameLogic.startLevel(levelNumber);

        do {
            System.out.println("Enter a key (W/A/S/D): ");
            String key = scanner.next().toLowerCase();

            switch (key) {
                case "w":
                    gameLogic.movePlayer(Direction.UP);
                    break;
                case "a":
                    gameLogic.movePlayer(Direction.LEFT);
                    break;
                case "s":
                    gameLogic.movePlayer(Direction.DOWN);
                    break;
                case "d":
                    gameLogic.movePlayer(Direction.RIGHT);
                    break;
                case "f":
                    gameLogic.playerActivatePowerUp();
                    break;
                case "p":
                    gameLogic.pauseGame();
                    pauseMenu();
                    break;
                default:
                    System.out.println("Invalid key.");
                    break;
            }

            System.out.println(gameLogic);
        }while(gameLogic.isRunningAndAlive());

        saveScoreOfPlayer();
        gameLogic.restartPlayerScore();
        System.out.println("LEVEL CLEARED!! BACK TO MAIN MENU");

    }
    public void saveScoreOfPlayer() {
        if (gameLogic.getScorePlayerWhenFinish()== null){
            return;
        }
        Score scoreAux = new Score(gameLogic.getScorePlayerWhenFinish().getTotalScore());
        this.lisScoreReturn.add(scoreAux);
    }
    public ArrayList<Score> getScoreOfPlayer(){
        return lisScoreReturn;
    }
    public void pauseMenu() {

        System.out.println("1. CONTINUE");
        System.out.println("2. SAVE GAME");
        System.out.println("3. BACK TO MENU LEVEL");
        System.out.println("Select an option: ");

        int number = scanner.nextInt();

        switch (number) {
            case 1:
                gameLogic.restartGame();
                // Continue game
                break;
            case 2:
                //saveGame();
                break;
            case 3:
                menuLevel();
                break;
            default:
                System.out.println("Invalid option, choose 1, 2 or 3.");
                break;
        }

    }
}