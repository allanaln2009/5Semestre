package aula3;

public class Notas {
	public static float[] pegaNotas(String notasStr){
		String[] vetNotasStr = new String[4];
		float[] notasFlo = new float[4];
		vetNotasStr = notasStr.split(";"); // separa notas digitas em um vetor
		float val;
		for (int i = 0; i < vetNotasStr.length; i++) {
			try{
				val = Float.parseFloat(vetNotasStr[i]); // converte nota em string para float 
			}catch(NumberFormatException e){
				System.out.println("Digite valores válidos. Ex: 8.75; 7.759; 9.5;10");
				return null;
			}
			if(val < 0 || val > 10){ // avalia se notas estão dentro dos padrões
				System.out.println("Digite valores válidos. Ex: 8.75; 7.759; 9.5;10");
				return null;
			}
			try{
				notasFlo[i] = val; // atribui nota à respectiva posição
			}catch(ArrayIndexOutOfBoundsException e){
				continue;
			}
		}
		return notasFlo;
	}
	public static float calculaMedia(float[] notas){
		float media = 0;
		int tam = notas.length; // quantidade de notas
		for (float f : notas) {
			media += f;
		}
		media = media/tam;
		//System.out.println("soma: " + soma + " média " + media);
		return media;
	}
	public static String situacaoAluno(float media){
		if(media < 6){
			return "Reprovado";
		}else{
			return "Aprovado";
		}
	}
}
