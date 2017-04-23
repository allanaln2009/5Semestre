package lista2;

public class ex3 {

	public static void main(String[] args) {
		int contador = 0;
		int somaImpares = 0;
		long multPares = 0;
		for (int i = 0; i < 30; i++) { // entre 0 e 30 = 1 ao 29
			if(i%2 != 0){
				somaImpares += i;
			}else{
				if(contador > 0){
					multPares *= i;
				}else{ // ignora a primeira passagem no loop e descarta o zero
					contador++;
					multPares = 1;
				}
			}
		}
		System.out.println("Soma dos impares: " + somaImpares + "\nMultiplicação dos pares: " + multPares);
	}
}
