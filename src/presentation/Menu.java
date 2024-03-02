package presentation;

import business.Direction;
import business.GameLogic;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static GameLogic gameLogic = new GameLogic();

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
                    characterMenu();
                    break;
                case 2:
                    System.out.println("Pro: 100000pts \n Juan Mateo: 0pts");
                    break;
                case 3:
                    System.out.println("You just entered the world, may god help you");
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

    public static void characterMenu() {
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

    public static void menuLevel() {

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

    public void pauseMenu() {

        System.out.println("1. CONTINUE");
        System.out.println("2. SAVE GAME");
        System.out.println("3. BACK TO MENU");
        System.out.println("Select an option: ");

        int number = scanner.nextInt();

        switch (number) {
            case 1:
                // Continue game
                break;
            case 2:
                saveGame();
                break;
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Invalid option, choose 1, 2 or 3.");
                break;
        }

    }

    public static void playGame(int levelNumber) {

        System.out.println("Game started - Level " + levelNumber);

        gameLogic = new GameLogic();
        gameLogic.startLevel(levelNumber);

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
                default:
                    System.out.println("Invalid key.");
                    break;
            }

            System.out.println(gameLogic);
        }while(gameLogic.isRunningAndAlive());

        System.out.println("LEVEL CLEARED!! BACK TO MAIN MENU");

    }

    private static void saveGame() {
        // TODO: Implementar la función de guardar datos
    }

}