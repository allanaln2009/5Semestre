package aula2;

import java.util.ArrayList;
import java.util.Scanner;
// Calculadora
public class exercicio4{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		//int x =0;
		int saida = 0;
		//Aluno[] lista = new Aluno[10];
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		while (saida != 0) {
			//lista[x] = new Aluno();
			lista.add(new Aluno());
			//int tamObj = lista.size();
		System.out.print("Digite o primeiro valor: ");
		float v1 = ler.nextInt();
		System.out.print("Digite a operação(+, -, *, /): ");
		String op = ler.next();
		System.out.print("Digite o segundo valor: ");
		float v2 = ler.nextInt();
		float resultado = 0;
		if(op.equals("+")){
			resultado = v1+v2;
		}else if(op.equals("-")){
			resultado = v1-v2;
		}else if(op.equals("*")){
			resultado = v1*v2;
		}else if(op.equals("/")){
			resultado = v1/v2;
		}else{
			System.out.println("Digite uma operação válida.");
		}
		System.out.print("O resultado é: " + resultado);			
		System.out.print("Deseja sair? 1 sim/ 0 não: ");
//		String 
		}
		ler.close();
	}
}
