import java.util.Random;
import java.util.Scanner;

public class casino {

	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(
				"                                                                                                                             \r\n"
						+ "                                                                                                                             \r\n"
						+ "        CCCCCCCCCCCCC               AAA                 SSSSSSSSSSSSSSS IIIIIIIIIINNNNNNNN        NNNNNNNN     OOOOOOOOO     \r\n"
						+ "     CCC::::::::::::C              A:::A              SS:::::::::::::::SI::::::::IN:::::::N       N::::::N   OO:::::::::OO   \r\n"
						+ "   CC:::::::::::::::C             A:::::A            S:::::SSSSSS::::::SI::::::::IN::::::::N      N::::::N OO:::::::::::::OO \r\n"
						+ "  C:::::CCCCCCCC::::C            A:::::::A           S:::::S     SSSSSSSII::::::IIN:::::::::N     N::::::NO:::::::OOO:::::::O\r\n"
						+ " C:::::C       CCCCCC           A:::::::::A          S:::::S              I::::I  N::::::::::N    N::::::NO::::::O   O::::::O\r\n"
						+ "C:::::C                        A:::::A:::::A         S:::::S              I::::I  N:::::::::::N   N::::::NO:::::O     O:::::O\r\n"
						+ "C:::::C                       A:::::A A:::::A         S::::SSSS           I::::I  N:::::::N::::N  N::::::NO:::::O     O:::::O\r\n"
						+ "C:::::C                      A:::::A   A:::::A         SS::::::SSSSS      I::::I  N::::::N N::::N N::::::NO:::::O     O:::::O\r\n"
						+ "C:::::C                     A:::::A     A:::::A          SSS::::::::SS    I::::I  N::::::N  N::::N:::::::NO:::::O     O:::::O\r\n"
						+ "C:::::C                    A:::::AAAAAAAAA:::::A            SSSSSS::::S   I::::I  N::::::N   N:::::::::::NO:::::O     O:::::O\r\n"
						+ "C:::::C                   A:::::::::::::::::::::A                S:::::S  I::::I  N::::::N    N::::::::::NO:::::O     O:::::O\r\n"
						+ " C:::::C       CCCCCC    A:::::AAAAAAAAAAAAA:::::A               S:::::S  I::::I  N::::::N     N:::::::::NO::::::O   O::::::O\r\n"
						+ "  C:::::CCCCCCCC::::C   A:::::A             A:::::A  SSSSSSS     S:::::SII::::::IIN::::::N      N::::::::NO:::::::OOO:::::::O\r\n"
						+ "   CC:::::::::::::::C  A:::::A               A:::::A S::::::SSSSSS:::::SI::::::::IN::::::N       N:::::::N OO:::::::::::::OO \r\n"
						+ "     CCC::::::::::::C A:::::A                 A:::::AS:::::::::::::::SS I::::::::IN::::::N        N::::::N   OO:::::::::OO   \r\n"
						+ "        CCCCCCCCCCCCCAAAAAAA                   AAAAAAASSSSSSSSSSSSSSS   IIIIIIIIIINNNNNNNN         NNNNNNN     OOOOOOOOO \n\n");

		int dinero = 5000;
		String eleccion;
		boolean juego = true;

		while (juego == true) {
			System.out.println("\n\n");
			System.out.println(" *******************");
			System.out.println("  * DINERO : " + dinero + " € *");
			System.out.println(" *******************");
			do {
				System.out.println("A que juego quieres jugar \n a) Bingo\n b) Crash\n c) Ruleta\n d) Salir");
				eleccion = teclado.nextLine().toLowerCase();
			} while (!eleccion.equals("a") && !eleccion.equals("b") && !eleccion.equals("c") && !eleccion.equals("d"));
			
			if(dinero <= 0) {
				juego = false;
			}else if (eleccion.equals("a")) {
				dinero = juegobingo(dinero);
			} else if (eleccion.equals("b")) {
				dinero = juegocrash(dinero);
			} else if (eleccion.equals("c")) {
				dinero = juegoruleta(dinero);
			} else {
				juego = false;
			}
		}
		System.out.println("Adios!, La proxima vez, vuelve con mas dinero!");
	}

	// BINGO
	public static int juegobingo(int dinero) {
		System.out.println("BIENVENIDOS AL CASINO");
		Scanner sc = new Scanner(System.in);
		int num = 0;

		System.out.println(" /$$$$$$$  /$$$$$$ /$$   /$$  /$$$$$$   /$$$$$$ \r\n"
				+ "| $$__  $$|_  $$_/| $$$ | $$ /$$__  $$ /$$__  $$\r\n"
				+ "| $$  \\ $$  | $$  | $$$$| $$| $$  \\__/| $$  \\ $$\r\n"
				+ "| $$$$$$$   | $$  | $$ $$ $$| $$ /$$$$| $$  | $$\r\n"
				+ "| $$__  $$  | $$  | $$  $$$$| $$|_  $$| $$  | $$\r\n"
				+ "| $$  \\ $$  | $$  | $$\\  $$$| $$  \\ $$| $$  | $$\r\n"
				+ "| $$$$$$$/ /$$$$$$| $$ \\  $$|  $$$$$$/|  $$$$$$/\r\n"
				+ "|_______/ |______/|__/  \\__/ \\______/  \\______\n");

		int elegir = 0;
		String siOno = "none";
		boolean repetir = true;
		String jugarrep = "none";

		do {
			try {
				System.out.println("Elige el modo de juego: \n[1] Jugador VS IA \n[2] jugador VS jugador");
				elegir = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("Caracter inválido, vuelve a elegir \n");
			}
		} while (elegir != 1 && elegir != 2);

		sc.nextLine();

		if (elegir == 1) {
			String carton[][][] = new String[2][3][5];

			while (repetir) {
				do {
					try {
						System.out.println("Precio del cartón: 10€ \nSaldo actual: " + dinero);
						System.out.println("Quieres comprar un cartón? (si/no)");
						siOno = sc.nextLine().toLowerCase();
					} catch (Exception e) {
						System.out.println("Caracter inválido, vuelve a elegir \n");
					}
				} while (!siOno.equals("si") && !siOno.equals("no"));

				if (siOno.equals("si")) {
					dinero = dinero - 10;
					System.out.println("Perfecto, eres el JUGADOR 1");
					try {
						Thread.sleep(2 * 2000);
					} catch (Exception e) {
						System.out.println(e);
					}

					rellenar(carton);
					bingo(carton, true, dinero);

				} else if (siOno.equals("no")) {
					System.out.println("No podemos dejaros jugar, fuera de aquí!");
					break;
				}
				do {
					try {
						System.out.println("Quieres volver a jugar? (si/no)");
						jugarrep = sc.nextLine().toLowerCase();
					} catch (Exception e) {
						System.out.println("Caracter inválido, vuelve a elegir \n");
					}
				} while (!siOno.equals("si") && !siOno.equals("no"));

				if (jugarrep.equals("si")) {
					repetir = true;
				} else {
					repetir = false;
				}

			}
			System.out.println("Hasta pronto!!!");

		} else {
			num = cuantos();
			String carton[][][] = new String[num][3][5];

			while (repetir) {
				do {
					try {
						System.out.println("Precio del cartón: 10€ \nSaldo actual: " + dinero);
						System.out.println("Quieres comprar cartones (si/no)");
						siOno = sc.nextLine().toLowerCase();
					} catch (Exception e) {
						System.out.println("Caracter inválido, vuelve a elegir \n");
					}
				} while (!siOno.equals("si") && !siOno.equals("no"));

				if (siOno.equals("si")) {
					dinero = dinero - (10 * carton.length);

					rellenar(carton);
					bingo(carton, false, dinero);

				} else if (siOno.equals("no")) {
					System.out.println("No podemos dejaros jugar, fuera de aquí!");
					break;
				}

				do {
					try {
						System.out.println("Quereis volver a jugar? (si/no)");
						jugarrep = sc.nextLine().toLowerCase();
					} catch (Exception e) {
						System.out.println("Caracter inválido, vuelve a elegir \n");
					}
				} while (!siOno.equals("si") && !siOno.equals("no"));

				if (jugarrep.equals("si")) {
					repetir = true;
				} else {
					repetir = false;
				}

			}
			System.out.println("Hasta pronto");
		}
		return dinero;
	}

	public static int cuantos() {
		Scanner teclado = new Scanner(System.in);

		int numero = 0;
		do {
			try {
				System.out.println("Inserta el numero de Jugadores: (max 6)");
				numero = Integer.parseInt(teclado.next());
			} catch (Exception e) {

			}
		} while (numero < 1 || numero > 6);

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

	public static void bingo(String mapa[][][], boolean ia, int dinero) {
		Random aleatorio = new Random();

		int temp = 0;
		int vector[] = new int[90];
		boolean repetido = true;
		boolean fin = false;
		boolean comprobar = false;
		boolean encontrada = false;
		int ganador = 1;

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
						comprobar = linea(mapa[x]);

						if (comprobar == true && encontrada == false) {
							System.out.println("LINEA DEL JUGADOR " + (x + 1));
							encontrada = true;
							if (ganador == (x + 1)) {
								dinero = dinero + 20;
							}
							try {
								Thread.sleep(2 * 2000);
							} catch (Exception e) {
								System.out.println(e);
							}
						}

						if (lleno(mapa[x]) == true) {
							fin = true;
							System.out.println("BINGO, EL JUGADOR " + (x + 1) + " HA GANADO");
							if (ganador == (x + 1)) {
								dinero = dinero + 30;
							}
							i = vector.length;
						}
					}
					if (fin == false) {
						try {
							Thread.sleep(1 * 500);
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
											Thread.sleep(1 * 500);
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

	public static boolean linea(String[][] carton) {

		int contador = 0;

		for (int z = 0; z < carton.length; z++) {
			contador = 0;
			for (int j = 0; j < carton[z].length; j++) {
				if (carton[z][j].equals("-1")) {
					contador++;
				}
			}
			if (contador == 5) {
				return true;
			}
		}
		return false;

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

	// CRASH
	

	// RULETA	//RULETA
	public static int juegoruleta(int dinero) {
		Scanner teclado = new Scanner(System.in);

		int apuesta = 0;
		int numero = 0;

		String respuesta;
		String opcion;
		String parOimpar;
		String rojoOnegro;

		boolean jugar = true;

		System.out.println("$$$$$$$\\  $$\\   $$\\ $$\\       $$$$$$$$\\ $$$$$$$$\\  $$$$$$\\  \r\n"
				+ "$$  __$$\\ $$ |  $$ |$$ |      $$  _____|\\__$$  __|$$  __$$\\ \r\n"
				+ "$$ |  $$ |$$ |  $$ |$$ |      $$ |         $$ |   $$ /  $$ |\r\n"
				+ "$$$$$$$  |$$ |  $$ |$$ |      $$$$$\\       $$ |   $$$$$$$$ |\r\n"
				+ "$$  __$$< $$ |  $$ |$$ |      $$  __|      $$ |   $$  __$$ |\r\n"
				+ "$$ |  $$ |$$ |  $$ |$$ |      $$ |         $$ |   $$ |  $$ |\r\n"
				+ "$$ |  $$ |\\$$$$$$  |$$$$$$$$\\ $$$$$$$$\\    $$ |   $$ |  $$ |\r\n"
				+ "\\__|  \\__| \\______/ \\________|\\________|   \\__|   \\__|  \\__|\n\n");

		while (jugar == true) {

			System.out.println(" *******************");
			System.out.println("  * SALDO : " + dinero + " € *");
			System.out.println(" *******************");

			do {
				System.out.println("Quieres apostar en la ruleta ? \n-Si \n-No");
				respuesta = teclado.nextLine().toLowerCase();
			} while (!respuesta.equals("si") && !respuesta.equals("no"));

			if (respuesta.equals("si") && dinero <= 0) {
				System.out.println("NO TIENE DINERO PARA SEGUIR APOSTANDO... LO SENTIMOS");
				jugar = false;
			} else if (respuesta.equals("no")) {
				jugar = false;
			} else {
				do {
					apuesta = 0;
					try {
						System.out.println("Cuanto quieres apostar de tus " + dinero + " € ?");
						apuesta = Integer.parseInt(teclado.next());
					} catch (Exception e) {
						System.out.println("Caracter invalido");
					}
				} while (apuesta > dinero || apuesta <= 0);
				dinero = dinero - apuesta;

				teclado.nextLine();

				do {
					System.out.println(
							"Elige la opcion de apuesta: \n a) Par o Impar\n b) Rojo o Negro\n c) Un numero\n d) Multiples de 3\n e) Multiples de 5\n f) Cancelar apuesta");
					opcion = teclado.nextLine().toLowerCase();
				} while (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") && !opcion.equals("d")
						&& !opcion.equals("e") && !opcion.equals("f"));

				if (opcion.equals("a")) {

					do {
						System.out.println("Elige una opcion : \n a) Par\n b) Impar");
						parOimpar = teclado.nextLine();
					} while (!parOimpar.equals("a") && !parOimpar.equals("b"));

					dinero = dinero + parImpar(apuesta, juego(), parOimpar);

				} else if (opcion.equals("b")) {

					do {
						System.out.println("Elige una opcion : \n a) Rojo\n b) Negro");
						rojoOnegro = teclado.nextLine();
					} while (!rojoOnegro.equals("a") && !rojoOnegro.equals("b"));

					dinero = dinero + rojoNegro(apuesta, juego(), rojoOnegro);

				} else if (opcion.equals("c")) {

					do {
						numero = -1;
						try {
							System.out.println("A que numero quieres apostar? [0-36]");
							numero = Integer.parseInt(teclado.next());
						} catch (Exception e) {
							System.out.println("Caracter invalido");
						}

					} while (numero < 0 || numero > 36);
					System.out.println("\n\nHa salido el numero " + numero + " de color " + ruleta()[numero][1]);

					if (juego() == numero) {
						System.out.println("FELICIDADES!! Tuviste mucha suerte, ha multiplicado tu apuesta por x16");
						dinero = dinero + (apuesta * 16);
					} else {
						System.out.println("NO adivinaste el numero, reconocemos que es muy dificil...");
					}
					teclado.nextLine();

				} else if (opcion.equals("d")) {
					dinero = dinero + multiple(apuesta, juego(), 3);
				} else if (opcion.equals("e")) {
					dinero = dinero + multiple(apuesta, juego(), 5);
				} else {
					System.out.println("Apuesta cancelada");
					dinero = dinero + apuesta;
				}
			}
		}
		System.out.println("Que vaya muy bien!");
		return dinero;
	}

	public static int multiple(int saldo, int numero, int multi) {
		System.out.println("\n\nHa salido el numero " + numero + " de color " + ruleta()[numero][1]);

		if (numero % 3 == 0 && multi == 3 || numero % 5 == 0 && multi == 5) {
			System.out.println("Felicidades, has multiplicado tu apuesta x3");
			saldo = saldo * 3;
		} else {
			System.out.println("No ganaste esta apuesta, puede que la siguiente...");
			saldo = 0;
		}
		return saldo;
	}

	public static int rojoNegro(int saldo, int numero, String eleccion) {

		System.out.println("\n\nHa salido el numero " + numero + " de color " + ruleta()[numero][1]);

		if (ruleta()[numero][1].equals("rojo") && eleccion.equals("a")
				|| ruleta()[numero][1].equals("negro") && eleccion.equals("b")) {
			System.out.println("Tuviste suerte, FELICIDADES");
			saldo = saldo * 2;
		} else {
			System.out.println("Tuviste mala suerte, no adivinaste el color");
			saldo = 0;
		}

		return saldo;
	}

	public static int parImpar(int saldo, int numero, String eleccion) {

		System.out.println("\n\nHa salido el numero " + numero + " de color " + ruleta()[numero][1]);

		if (numero % 2 == 0) {
			if (eleccion.equals("a")) {
				System.out.println("Felicidades el numero " + numero + " es PAR");
				saldo = saldo * 2;
			} else {
				System.out.println("El numero " + numero + " NO es PAR");
				saldo = 0;
			}
		} else {
			if (eleccion.equals("a")) {
				System.out.println("El numero " + numero + " NO es IMPAR");
				saldo = 0;
			} else {
				System.out.println("Felicidades el numero " + numero + " es IMPAR");
				saldo = saldo * 2;
			}
		}
		return saldo;
	}

	public static int juego() {
		Random aleatorio = new Random();
		int vector[] = new int[16];
		int num = 0;
		int i = 0;
		boolean repetido = false;

		int valor = 0;
		System.out.println("\n");
		valor = aleatorio.nextInt(37);
		while (i < 100) {
			repetido = false;
			num = aleatorio.nextInt(37);

			int acelerador = 0;
			if (i < 10) {
				acelerador = 40;
			} else if (i < 20) {
				acelerador = 70;
			} else if (i < 40) {
				acelerador = 100;
			} else if (i < 60) {
				acelerador = 150;
			} else if (i < 70) {
				acelerador = 220;
			} else if (i < 90) {
				acelerador = 300;
			} else {
				acelerador = 450;
			}
			try {
				Thread.sleep(acelerador);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (i == 99) {
				if (valor == 0) {
					System.out.print(ANSI_GREEN + "" + valor + " " + ANSI_RESET);
				} else if (valor % 2 == 0) {
					System.out.print(ANSI_BLACK + "" + valor + " " + ANSI_RESET);
				} else {
					System.out.print(ANSI_RED + "" + valor + " " + ANSI_RESET);
				}
			} else if (i == 40 || i == 80) {
				System.out.println("\n");
			} else {
				if (num == 0) {
					System.out.print(ANSI_GREEN + "" + num + " " + ANSI_RESET);
				} else if (num % 2 == 0) {
					System.out.print(ANSI_BLACK + "" + num + " " + ANSI_RESET);
				} else {
					System.out.print(ANSI_RED + "" + num + " " + ANSI_RESET);
				}
			}
			i++;
		}
		return valor;
	}

	public static String[][] ruleta() {
		String ruleta[][] = new String[37][2];

		for (int i = 0; i < ruleta.length; i++) {
			for (int z = 0; z < ruleta[i].length; z++) {
				if (i == 0) {
					if (z == 0) {
						ruleta[i][z] = "0";
					} else {
						ruleta[i][z] = "verde";
					}
				} else {
					if (z == 0) {
						ruleta[i][z] = String.valueOf(i);
					} else {
						if (i % 2 == 0) {
							ruleta[i][z] = "negro";
						} else {
							ruleta[i][z] = "rojo";
						}
					}
				}
			}
		}
		return ruleta;
	}

	//CRASH
	public static int juegocrash(double dinero) {
		
		Scanner sc = new Scanner(System.in);
		
		String decicion = "";
		
		double eleccion = 0;
		double elnumerito = 0;
		double money_apuesta = 0;
		double el_ultimo_porcentaje = 0;
		
		boolean seguirsiono = true;
		int dados = 0;

		cartel();

		do {
			System.out.println("Sabes como jugar al crash? (si/no)");
			decicion = sc.nextLine().toLowerCase();
		}while(!decicion.equals("si") && !decicion.equals("no"));
		
		if (decicion.equals("no")) {
			como_juugar();
			decicion = "";
		}
		
		
		
		while (seguirsiono == true) {

			
			
			System.out.println("Saldo actual "+dinero+" €");
			
			
			do {
				money_apuesta = -1;
				try {
					System.out.println("Cuanto quieres apostar? (max "+dinero+" €)");
					money_apuesta = Integer.parseInt(sc.next());
				} catch (Exception e) {
					System.out.println("Caracter invalido");
				}
			} while (money_apuesta > dinero || money_apuesta < 0);
			
			do {
				eleccion = -1;
				try {
					System.out.println("Por cuanto quieres multiplicar tu apuesta?");
					eleccion = Double.parseDouble(sc.next());
				}catch(Exception e) {
					System.out.println("Caracter invalido");
				}

			} while (eleccion > 100.00 || eleccion < 0);
			
			sc.nextLine();

			el_ultimo_porcentaje = la_chicha(dados, elnumerito);

			if (eleccion <= el_ultimo_porcentaje) {
				double newmoney = (money_apuesta * eleccion);
				dinero = dinero-money_apuesta;
				dinero = dinero + newmoney;
				System.out.println("\nHas ganado "+newmoney+" €");
			}else {
				dinero = dinero - money_apuesta;
				System.out.println("\nHas perdido "+money_apuesta+" €");
			}
			
			if(dinero > 0) {
				
			do {
				try {
					System.out.println("Quieres seguir jugando? (si/no)");
					decicion = sc.nextLine().toLowerCase();
				} catch (Exception e) {
					System.out.println("Caracter inv�lido, vuelve a elegir \n");
				}
			}while(!decicion.equals("si") && !decicion.equals("no"));

			if (decicion.equals("no")) {
				seguirsiono = false;
			}
			}else {
				break;
			}
			
		}
		System.out.println("Hasta pronto!!!");		
		return (int)dinero;
	}

	public static double la_chicha(int dados, double elnumerito) {
		Random rand = new Random();
		double el_ultimo = 0;

		while (elnumerito < 100.00) {
			if (elnumerito >= 0.00 && elnumerito <= 1.00) {
				dados = rand.nextInt(50);
			} else if (elnumerito >= 1.01 && elnumerito <= 10.00) {
				dados = rand.nextInt(20);
			} else if (elnumerito >= 10.01 && elnumerito <= 30.00) {
				dados = rand.nextInt(10);
			} else if (elnumerito >= 30.01 && elnumerito <= 40.00) {
				dados = rand.nextInt(9);
			} else if (elnumerito >= 40.01 && elnumerito <= 50.00) {
				dados = rand.nextInt(8);
			} else if (elnumerito >= 50.01 && elnumerito <= 60.00) {
				dados = rand.nextInt(7);
			} else if (elnumerito >= 60.01 && elnumerito <= 70.00) {
				dados = rand.nextInt(6);
			} else if (elnumerito >= 70.01 && elnumerito <= 1000.00) {
				dados = rand.nextInt(2);
			}

			if (dados == 1) {
				elnumerito = 100.00;
			}

			elnumerito = elnumerito + 0.1;
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (elnumerito > 100.00) {
				System.out.println("CRASH");
			} else {
				el_ultimo = elnumerito;
				System.out.print("x");
				System.out.println(String.format("%.2f", elnumerito));
			}
		}

		return el_ultimo;
	}

	public static void cartel() {
		System.out.println("  /$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$   /$$\r\n"
				+ " /$$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$  | $$\r\n"
				+ "| $$  \\__/| $$  \\ $$| $$  \\ $$| $$  \\__/| $$  | $$\r\n"
				+ "| $$      | $$$$$$$/| $$$$$$$$|  $$$$$$ | $$$$$$$$\r\n"
				+ "| $$      | $$__  $$| $$__  $$ \\____  $$| $$__  $$\r\n"
				+ "| $$    $$| $$  \\ $$| $$  | $$ /$$  \\ $$| $$  | $$\r\n"
				+ "|  $$$$$$/| $$  | $$| $$  | $$|  $$$$$$/| $$  | $$\r\n"
				+ " \\______/ |__/  |__/|__/  |__/ \\______/ |__/  |__/\n\n");
	}

	public static void como_juugar() {
		System.out.println(
				"El CRASH es un juego de apuestas para adultos, Por su bien solo apueste dinero que no necesite\nEl juego funciona de la siguiente manera:\nUsted tiene que introducir una cantidad a apostar, esta cantidad la puede per o multiplicar segun su suerte\npara ganar debe retirar su dinero en un porcentaje menor al porcentaje donde el juego para(Si pasa esto se dice que el juego CRASHEO o que a EXPLOTADO\n");
	}
}
