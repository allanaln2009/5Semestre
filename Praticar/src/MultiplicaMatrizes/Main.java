package MultiplicaMatrizes;

//import java.util.Random;

public class Main {
	static int v = 1;
	public static void main(String[] args) {
		Integer[][] v1 = new Integer[10][7];
		Integer[][] v2 = new Integer[7][10];
		
		populaVetor(v1);
		populaVetor(v2);	
		
		MultiplicaMatrizes mm = new MultiplicaMatrizes(v1, v2);
		
		exibeVetor(v1); System.out.println();
		exibeVetor(v2); System.out.println();
		exibeVetor(mm.getResultado()); System.out.println();
	}

	private static void exibeVetor(Integer[][] vet) {
		for(int i = 0; i < vet.length; i++){
			for(int j = 0; j < vet[i].length; j++){
				System.out.print(vet[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void populaVetor(Integer[][] vet) {
		//Random r = new Random();
		//int v = 0;
		for(int i = 0; i < vet.length; i++){
			for(int j = 0; j < vet[i].length; j++){
				//vet1[i][j] = Math.abs((int) r.nextInt(201));
				//vet[i][j] = r.nextInt(201);
				///*
				vet[i][j] = v;
				v++;
				//*/
			}
		}
	}

}
