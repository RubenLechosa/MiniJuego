package ruleta;

import java.util.Random;
import java.util.Scanner;

public class main {
	/*Se recomienda descargar en el marketplace (ANSI Escape in console) para una mejor experiencia*/
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		int dinero = 1000;
		int apuesta = 0;
		int numero = 0;
		
		String respuesta ;
		String opcion ;
		String parOimpar ;
		String rojoOnegro ;
		
		boolean jugar = true;
		
		System.out.println(" _______   __    __  __        ________  ________   ______  \r\n"
				+ "|       \\ |  \\  |  \\|  \\      |        \\|        \\ /      \\ \r\n"
				+ "| $$$$$$$\\| $$  | $$| $$      | $$$$$$$$ \\$$$$$$$$|  $$$$$$\\\r\n"
				+ "| $$__| $$| $$  | $$| $$      | $$__       | $$   | $$__| $$\r\n"
				+ "| $$    $$| $$  | $$| $$      | $$  \\      | $$   | $$    $$\r\n"
				+ "| $$$$$$$\\| $$  | $$| $$      | $$$$$      | $$   | $$$$$$$$\r\n"
				+ "| $$  | $$| $$__/ $$| $$_____ | $$_____    | $$   | $$  | $$\r\n"
				+ "| $$  | $$ \\$$    $$| $$     \\| $$     \\   | $$   | $$  | $$\r\n"
				+ " \\$$   \\$$  \\$$$$$$  \\$$$$$$$$ \\$$$$$$$$    \\$$    \\$$   \\$$\n\n");
		
		while(jugar == true) {
			
			System.out.println(" *******************");
			System.out.println("  * SALDO : "+dinero+" € *");
			System.out.println(" *******************");

			
			do {
				System.out.println("Quieres apostar en la ruleta ? \n-Si \n-No");
				respuesta = teclado.nextLine().toLowerCase();
			}while(!respuesta.equals("si") && !respuesta.equals("no"));

			if(respuesta.equals("si") && dinero <= 0) {
				System.out.println("NO TIENE DINERO PARA SEGUIR APOSTANDO... LO SENTIMOS");
				jugar = false;
			}else if(respuesta.equals("no")) {
				jugar = false;
			} else {
				do {
					apuesta = 0;
					try {
						System.out.println("Cuanto quieres apostar de tus "+dinero+" € ?");
						apuesta = Integer.parseInt(teclado.next());
					}catch(Exception e) {
						System.out.println("Caracter invalido");
					}
				}while(apuesta > dinero || apuesta <= 0);
				dinero = dinero - apuesta;
				
				teclado.nextLine();
				
				do {
					System.out.println("Elige la opcion de apuesta: \n a) Par o Impar\n b) Rojo o Negro\n c) Un numero\n d) Multiples de 3\n e) Multiples de 5\n f) Cancelar apuesta");
					opcion  = teclado.nextLine().toLowerCase();
				}while(!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") && !opcion.equals("d") && !opcion.equals("e") && !opcion.equals("f"));
				

				if(opcion.equals("a")) {
					
					do {
						System.out.println("Elige una opcion : \n a) Par\n b) Impar");
						parOimpar = teclado.nextLine();
					}while(!parOimpar.equals("a") && !parOimpar.equals("b"));

					dinero = dinero + parImpar(apuesta, juego(), parOimpar);
					
				}else if(opcion.equals("b")) {
					
					do {
						System.out.println("Elige una opcion : \n a) Rojo\n b) Negro");
						rojoOnegro = teclado.nextLine();
					}while(!rojoOnegro.equals("a") && !rojoOnegro.equals("b"));
					
					dinero = dinero + rojoNegro(apuesta, juego(), rojoOnegro);
					
				}else if(opcion.equals("c")) {
					
					do {
						numero = -1;
						try {
							System.out.println("A que numero quieres apostar? [0-36]");
							numero = Integer.parseInt(teclado.next());
						}catch(Exception e) {
							System.out.println("Caracter invalido");
						}

					}while(numero < 0 || numero > 36);
					System.out.println("\n\nHa salido el numero "+numero+" de color "+ruleta()[numero][1]);

					if(juego() == numero) {
						System.out.println("FELICIDADES!! Tuviste mucha suerte, ha multiplicado tu apuesta por x16");
						dinero = dinero + (apuesta*16);
					}else {
						System.out.println("NO adivinaste el numero, reconocemos que es muy dificil...");
					}
					teclado.nextLine();
					
				}else if(opcion.equals("d")) {
					dinero = dinero + multiple(apuesta, juego(), 3);
				}else if(opcion.equals("e")) {
					dinero = dinero + multiple(apuesta, juego(), 5);
				}else {
					System.out.println("Apuesta cancelada");
					dinero = dinero + apuesta;
				}
			}
		}
		System.out.println("Que vaya muy bien!");
	}
	public static int multiple(int saldo, int numero, int multi) {
		System.out.println("\n\nHa salido el numero "+numero+" de color "+ruleta()[numero][1]);

		if(numero % 3 == 0 && multi == 3 || numero % 5 == 0 && multi == 5) {
			System.out.println("Felicidades, has multiplicado tu apuesta x3");
			saldo = saldo *3;
		}else {
			System.out.println("No ganaste esta apuesta, puede que la siguiente...");
			saldo = 0;
		}
		return saldo;
	}
	public static int rojoNegro(int saldo, int numero, String eleccion) {
		
		System.out.println("\n\nHa salido el numero "+numero+" de color "+ruleta()[numero][1]);
		
		if(ruleta()[numero][1].equals("rojo") && eleccion.equals("a") || ruleta()[numero][1].equals("negro") && eleccion.equals("b")) {
			System.out.println("Tuviste suerte, FELICIDADES");
			saldo = saldo * 2;
		}else {
			System.out.println("Tuviste mala suerte, no adivinaste el color");
			saldo = 0;
		}
		
		return saldo;
	}
	public static int parImpar(int saldo, int numero, String eleccion) {
		
		System.out.println("\n\nHa salido el numero "+numero+" de color "+ruleta()[numero][1]);
		
		if(numero % 2 == 0) {
			if(eleccion.equals("a")) {
				System.out.println("Felicidades el numero "+numero+" es PAR");
				saldo = saldo*2;
			}else {
				System.out.println("El numero "+numero+" NO es PAR");
				saldo = 0;
			}
		}else {
			if(eleccion.equals("a")) {
				System.out.println("El numero "+numero+" NO es IMPAR");
				saldo = 0;
			}else {
				System.out.println("Felicidades el numero "+numero+" es IMPAR");
				saldo = saldo*2;
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
		while(i<100) {
			repetido = false;
			num = aleatorio.nextInt(37);

			int acelerador = 0;
			if(i < 10) {
				acelerador = 40;
			}else if(i < 20) {
				acelerador = 70;
			}else if( i < 40) {
				acelerador = 100;
			}else if( i < 60) {
				acelerador = 150;
			}else if( i < 70) {
				acelerador = 220;
			}else if( i < 90) {
				acelerador = 300;
			}else {
				acelerador = 450;
			}
			try {
				Thread.sleep(acelerador);
			}catch(Exception e) {
				System.out.println(e);
			}
			if(i == 99) {
				if(valor == 0) {
					System.out.print(ANSI_GREEN +"" +valor +" " + ANSI_RESET);
				}else if(valor%2 == 0) {
					System.out.print(ANSI_BLACK +"" +valor+" " + ANSI_RESET);
				}else {
					System.out.print(ANSI_RED +"" +valor +" " + ANSI_RESET);
				}
			}else if(i == 40 || i == 80) {
				System.out.println("\n");
			}else {
				if(num == 0) {
					System.out.print(ANSI_GREEN +"" +num +" " + ANSI_RESET);
				}else if(num%2 == 0) {
					System.out.print(ANSI_BLACK +"" +num+" " + ANSI_RESET);
				}else {
					System.out.print(ANSI_RED +"" +num +" " + ANSI_RESET);
				}
			}
			i++;
		}
		return valor;
	}
	
	public static String [][] ruleta () {
		String ruleta[][] = new String [37][2];
		
		for(int i = 0; i<ruleta.length; i++) {
			for( int z = 0; z<ruleta[i].length; z++) {
				if(i == 0) {
					if( z == 0) {
						ruleta[i][z] = "0";
					}else {
						ruleta[i][z] = "verde";
					}
				}else {
					if(z == 0) {
						ruleta[i][z] = String.valueOf(i);
					}else {
						if(i % 2 == 0) {
							ruleta[i][z] = "negro";
						}else {
							ruleta[i][z] = "rojo";
						}
					}
				}
			}
		}
		return ruleta;
	}
	
	public static void mostrar(String[][]mapa) {
		for(int i = 0; i<mapa.length; i++) {
			System.out.println();
			for(int z = 0; z<mapa[i].length; z++) {
				System.out.print(mapa[i][z]+" ");
			}
		}
	}
}
