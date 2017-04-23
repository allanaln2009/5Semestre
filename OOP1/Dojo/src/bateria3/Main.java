package bateria3;

import java.util.Scanner;

public class Main {
	static Scanner l;
	static String[][] area;
	public static void main(String[] args) {
		l = new Scanner(System.in); 
		area = new String[7][8]; //7 linhas; 8 colunas;
		setaExemplo();
		//setaExemplo1();
		
		Mapa m = new Mapa(area);
		System.out.println("1° dia");
		m.mapa("desenha_mapa");
		for(int i = 2; i < 7; i++){
			System.out.println("\n" + i + "° dia");
			m.mapa("expande_fumaca");
			m.mapa("desenha_mapa");
		}
	}
	private static void setaExemplo1() {
		area[0][0] = "A";
		area[0][7] = "A";
		area[1][3] = "A";
		area[1][4] = "A";
		area[3][0] = "A";
		area[3][7] = "A";
		area[5][3] = "A";
		area[5][4] = "A";
		area[6][0] = "A";
		area[6][7] = "A";
		area[3][3] = "*";
		area[3][4] = "*";
	}
	private static void setaExemplo() {
		area[0][2] = "*";
		area[0][6] = "*";
		area[0][7] = "*";
		area[1][2] = "*";
		area[1][1] = "*";
		area[2][0] = "*";
		area[2][1] = "*";
		area[2][2] = "*";
		area[2][4] = "A";
		area[2][7] = "A";
		area[3][1] = "*";
		area[4][1] = "*";
		area[4][6] = "A";
		area[5][3] = "A";
	}
}
