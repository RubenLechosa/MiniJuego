import java.util.Random;
import java.util.Scanner;

public class Bingo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int elegir = 0;
		int num = 0;

		System.out.println(" /$$$$$$$ /$$$$$$/$$   /$$ /$$$$$$  /$$$$$$       \r\n"
				+ "| $$__  $|_  $$_| $$$ | $$/$$__  $$/$$__  $$      \r\n"
				+ "| $$  \\ $$ | $$ | $$$$| $| $$  \\__| $$  \\ $$      \r\n"
				+ "| $$$$$$$  | $$ | $$ $$ $| $$ /$$$| $$  | $$      \r\n"
				+ "| $$__  $$ | $$ | $$  $$$| $$|_  $| $$  | $$      \r\n"
				+ "| $$  \\ $$ | $$ | $$\\  $$| $$  \\ $| $$  | $$      \r\n"
				+ "| $$$$$$$//$$$$$| $$ \\  $|  $$$$$$|  $$$$$$/      \r\n"
				+ "|_______/|______|__/  \\__/\\______/ \\______/   \n    ");

		System.out.println("Elige un modo de juego: \n [1]Jugador vs Jugador \n [2]Jugador vs IA");
		elegir = sc.nextInt();

		while (elegir < 1 || elegir > 2) {
			System.out.println("Error: Elige un modo de juego: [1]Jugador vs Jugador [2]Jugador vs IA");
		}

		if (elegir == 1) {
			num = cuantos();
			String carton[][][] = new String[num][3][5];
			rellenar(carton);

			bingo(carton);

		} else {
			System.out.println("Esto es 2");
		}
	}

	public static int cuantos() {
		Scanner teclado = new Scanner(System.in);

		int numero = 0;

		System.out.println("Has elegido jugador vs jugador, inserta el numero de jugadores:(max 6)");
		numero = teclado.nextInt();

		while (numero < 1 || numero > 6) {
			System.out.println("Error: inserta el numero de jugadores: (max 6)");
			numero = teclado.nextInt();
		}

		return numero;

	}

	public static String[][][] rellenar(String mapa[][][]) {
		Random aleatorio = new Random();
		String temporal = "none";

		for (int i = 0; i < mapa.length; i++) {
			for (int z = 0; z < mapa[i].length; z++) {
				for (int j = 0; j < mapa[i][z].length; j++) {

					do {
						temporal = String.valueOf(aleatorio.nextInt(90) + 1);
					} while (comprobarRepString(mapa, temporal));

					mapa[i][z][j] = temporal;
				}
			}
		}
		return mapa;
	}

	public static void mostrar(String mapa[][][]) {

		for (int i = 0; i < mapa.length; i++) {
			System.out.println();
			System.out.print("JUGADOR " + (i + 1));
			System.out.println();
			for (int z = 0; z < mapa[i].length; z++) {
				System.out.println();
				for (int k = 0; k < mapa[i][z].length; k++) {
					System.out.print(mapa[i][z][k] + " ");

				}
			}
			System.out.println();
		}
	}

	public static void bingo(String mapa[][][]) {
		Random aleatorio = new Random();

		int temp = 0;
		int vector[] = new int[90];
		boolean repetido = true;
		boolean fin = false;

		System.out.println();
		mostrar(mapa);

		for (int i = 0; i < vector.length; i++) {
			repetido = true;

			while (repetido == true) {
				temp = aleatorio.nextInt(90) + 1;
				repetido = false;
				for (int z = 0; z < vector.length; z++) {
					if (temp == vector[z]) {
						repetido = true;
					}
				}

				if (repetido == false) {
					vector[i] = temp;

					for (int x = 0; x < mapa.length; x++) {
						if (lleno(mapa[x]) == true) {
							fin = true;
							System.out.println("BINGO, el jugador " + (x + 1) + " ha ganado");
						}
					}
					if (fin == false) {
						try {
							Thread.sleep(1*200);
						} catch (Exception e) {
							System.out.println(e);
						}
						System.out.print(vector[i] + " ");

						for (int z = 0; z < mapa.length; z++) {
							
							for (int x = 0; x < mapa[z].length; x++) {
								for (int k = 0; k < mapa[z][x].length; k++) {
									if (Integer.parseInt(mapa[z][x][k]) == temp) {
										mapa[z][x][k] = "-1";
										System.out.println("\n");
										mostrar(mapa);
										System.out.println(
												"\nSe ha encontrado el numero " + temp + ", seguimos para BINGO \n");
										try {
											Thread.sleep(500);
										} catch (Exception e) {
											System.out.println(e);
										}
									}
								}
							}
						}

					}
				}
			}
		}
	}

	public static boolean lleno(String vector[][]) {
		boolean lleno = false;
		int contador = 0;

		for (int i = 0; i < vector.length; i++) {
			for (int z = 0; z < vector[i].length; z++) {
				if (vector[i][z].equals("-1")) {
					contador++;
				}
			}
		}
		if (contador == 15) {
			lleno = true;
		} else {
			lleno = false;
		}
		return lleno;
	}

	public static boolean comprobarRepString(String vector[][][], String temporal) {
		for (int i = 0; i < vector.length; i++) {
			for (int z = 0; z < vector[i].length; z++) {
				for (int j = 0; j < vector[i][z].length; j++) {
					if (vector[i][z][j] != null && vector[i][z][j].equals(temporal)) {
						return true;
					}

				}
			}
		}
		return false;
	}

}
