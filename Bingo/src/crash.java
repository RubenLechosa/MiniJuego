

import java.util.Random;
import java.util.Scanner;

public class crash {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String decicion = "";
		
		double dinero = 1000;
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
					System.out.println("Cuanto quieres apostar? (max "+dinero+")");
					money_apuesta = Integer.parseInt(sc.next());
				} catch (Exception e) {
					System.out.println("Caracter inválido");
				}
			} while (money_apuesta > dinero || money_apuesta < 0);
			
			do {
				eleccion = -1;
				try {
					System.out.println("Por cuanto quieres multiplicar tu apuesta?");
					eleccion = Double.parseDouble(sc.next());
				}catch(Exception e) {
					System.out.println("Caracter inválido");
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
					System.out.println("Caracter inválido, vuelve a elegir \n");
				}
			}while(!decicion.equals("si") && !decicion.equals("no"));

			if (decicion.equals("no")) {
				seguirsiono = false;
				System.out.println("Hasta pronto!!!");
			}
			}else {
				break;
			}
			
		}
		System.out.println("No te queda dinero, hasta pronto!!!");
		sc.close();
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
		System.out.println("\r\n" + "                                                                  \r\n"
				+ "                                                                  \r\n"
				+ "  .g8\"\"\"bgd `7MM\"\"\"Mq.        db       .M\"\"\"bgd `7MMF'  `7MMF'    \r\n"
				+ ".dP'     `M   MM   `MM.      ;MM:     ,MI    \"Y   MM      MM      \r\n"
				+ "dM'       `   MM   ,M9      ,V^MM.    `MMb.       MM      MM      \r\n"
				+ "MM            MMmmdM9      ,M  `MM      `YMMNq.   MMmmmmmmMM      \r\n"
				+ "MM.           MM  YM.      AbmmmqMA   .     `MM   MM      MM      \r\n"
				+ "`Mb.     ,'   MM   `Mb.   A'     VML  Mb     dM   MM      MM      \r\n"
				+ "  `\"bmmmd'  .JMML. .JMM..AMA.   .AMMA.P\"Ybmmd\"  .JMML.  .JMML.    \r\n"
				+ "                                                                  \r\n"
				+ "                                                                  \r\n" + "");
	}

	public static void como_juugar() {
		System.out.println(
				"El CRASH es un juego de apuestas para adultos, Por su bien solo apueste dinero que no necesite\nEl juego funciona de la siguiente manera:\nUsted tiene que introducir una cantidad a apostar, esta cantidad la puede per o multiplicar segun su suerte\npara ganar debe retirar su dinero en un porcentaje menor al porcentaje donde el juego para(Si pasa esto se dice que el juego CRASHEO o que a EXPLOTADO\n");
	}
}

