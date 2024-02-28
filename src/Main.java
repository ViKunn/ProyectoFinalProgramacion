import business.GameLogic;
import business.Direction;

import java.awt.*;
import java.util.Scanner;

import static presentation.Menu.mainMenu;

public class Main {
	public static void main(String[] args) {

		mainMenu();

	}
}

/*	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// Menú principal




			System.out.println("===== MENÚ PRINCIPAL =====");
			System.out.println("1. PLAY");
			System.out.println("2. SCORES");
			System.out.println("3. HELP");
			System.out.println("4. EXIT");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					// Lógica para el menú PLAY
					GameLogic gameLogic = initializeGameLogic();

					while (gameLogic.isRunning()) {
						System.out.println("Ingrese una tecla (w/a/s/d):");
						String tecla = scanner.next();

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
					break;
				case 2:
					System.out.println("Fernando: 100000pts \nMateo: 0pts");
					break;
				case 3:
					System.out.println("Solo llegaste al mundo, que te ayude dios");
					break;
				case 4:
					System.out.println("Saliendo del juego...");
					System.exit(0);
					break;
				default:
					System.out.println("Opción no válida.");
					break;
			}
		}
	}

	public static GameLogic initializeGameLogic() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("Selecciona un nivel:");
			System.out.println("1. Nivel Fácil");
			System.out.println("2. Nivel Difícil");
			System.out.println("3. Salir");
			System.out.print("Ingresa tu opción: ");

			opcion = scanner.nextInt();
			switch (opcion) {
				case 1:
					System.out.println("Has seleccionado el Nivel Fácil.");
					return new GameLogic(opcion);
				case 2:
					System.out.println("Has seleccionado el Nivel Difícil.");
					return new GameLogic(opcion);
				case 3:
					System.out.println("Saliendo del juego...");
					break;
				default:
					System.out.println("ERROR: Opción no válida.");
					break;
			}

		} while (opcion != 3);

		scanner.close();
		return null;
	}*/


/*
	TODO --> OBJETIVOS DEL DÍA
		- Posición monstruos

*/