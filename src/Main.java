import business.GameLogic;
import business.Direction;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		GameLogic gameLogic = inicializarGameLogic();
		Scanner scanner = new Scanner(System.in);

		while (gameLogic.isRunning()) {

			System.out.println("Ingrese una tecla (w/a/s/d):");
			String tecla = scanner.nextLine();

			switch (tecla) {
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
					gameLogic.playerPowerUps();
					break;

				default:
					System.out.println("Tecla no válida.");
					break;
			}

			System.out.println(gameLogic);
		}

		System.out.println("EL NIVEL SE PASÓ!! AQUÍ SE PRESENTARÍA EL MENU PRINCIPAL");
	}

	public static GameLogic inicializarGameLogic() {
		Scanner scanner = new Scanner(System.in);
		int opción;

		do {
			System.out.println("Selecciona un nivel:");
			System.out.println("1. Nivel Fácil");
			System.out.println("2. Nivel Difícil");
			System.out.println("3. Salir");
			System.out.print("Ingresa tu opción: ");

			opción = scanner.nextInt();
			switch (opción) {
				case 1:
					System.out.println("Has seleccionado el Nivel Fácil.");
					return new GameLogic(opción);
				case 2:
					System.out.println("Has seleccionado el Nivel Difícil.");
					return new GameLogic(opción);
				case 3:
					System.out.println("Saliendo del juego...");
					break;
				default:
					System.out.println("ERROR: Opción no válida.");
					break;
			}

		} while (opción != 3);

		scanner.close();
		return null;
	}

}

/*

	TODO --> OBJETIVOS DEL DÍA
		- Posición monstruos

*/