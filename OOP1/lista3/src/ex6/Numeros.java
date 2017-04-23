package ex6;

public class Numeros {
	private int n1;
	private int n2;
	private int soma = 0;
	private int inteiros = 0;
	private int impares = 0;
	private String texto = "";
	
	public Numeros(int n1, int n2){
		/*
		// garante que números serão tratados
		this.n1 = (n1 < n2) ? n1 : n2;
		this.n2 = (n1 < n2) ? n2 : n1;
		*/
		if(n1 > n2){
			System.out.println("Limite inferior maior que limite superior.");
			System.exit(0);
		}
		this.n1 = n1;
		this.n2 = n2;
		trataIntervalo();
	}
	
	public int getN1() {
		return n1;
	}
	public int getN2() {
		return n2;
	}
	public int somaInt(){
		return soma;
	}
	private void trataIntervalo(){
		for(int i = (n1+1); i < n2; i++){
			soma += i;
			inteiros++;
			if(i%2 != 0){
				impares++;
				texto += i + " é impar\n";
			}else
				texto += i + " é par\n";
		}
	}
	public int intsBetween(){
		return inteiros;
	}
	public int intsImpares(){
		return impares;
	}
	public String descNums(){
		return texto;
	}
}
