package bateria1;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		System.out.println("Escolha uma opção:\n 1.Arábico para romano\n 2.Romano para arábico");
		int num = l.nextInt();
		l.nextLine();
		if(num == 1){
			System.out.print("Digite o número arábico: ");
			num = l.nextInt();
			l.nextLine();
			System.out.println(new ArabicoParaRomano(num));			
		}else if(num == 2){
			System.out.print("Digite o número romano: ");
			String romano = l.nextLine();
			System.out.println(new RomanoParaArabico(romano));
		}
	}

}
