package bateria1;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		System.out.println("Escolha uma op��o:\n 1.Ar�bico para romano\n 2.Romano para ar�bico");
		int num = l.nextInt();
		l.nextLine();
		if(num == 1){
			System.out.print("Digite o n�mero ar�bico: ");
			num = l.nextInt();
			l.nextLine();
			System.out.println(new ArabicoParaRomano(num));			
		}else if(num == 2){
			System.out.print("Digite o n�mero romano: ");
			String romano = l.nextLine();
			System.out.println(new RomanoParaArabico(romano));
		}
	}

}
