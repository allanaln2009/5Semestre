package ex3;

import java.util.Scanner;

public class Main {
	static Scanner l;

	public static void main(String[] args){
		l = new Scanner(System.in);
		Jogo jogo;
		//while(true){
			jogo = new Jogo(pegaNumero());
			pegaVencedor(jogo);
		//}
	}

	private static void pegaVencedor(Jogo jogo) {
		int vencedor = jogo.comparaObj();
		if(vencedor == 0){
			System.out.println("Você venceu!");
		}else if(vencedor == 1){
			System.out.println("CPU venceu!");
		}
	}

	static int pegaNumero(){
		System.out.println("Escolha um:\n 1.Pedra\n 2.Papel\n 3.Tesoura");
		int v = 0;
		try{
			v = l.nextInt();
		}catch(Exception e){
			System.out.println("Valor inválido.");
			v = -1;
		}
		if(v == 1 || v == 2 || v == 3){
			return v-1;
		}
		return -1;
	}
}
