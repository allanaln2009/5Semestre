package ex4;

public class Notas {
	private float n1 = -1;
	private float n2 = -1;
	private float n3 = -1;
	private float media;
	
	public float getN1() {
		return n1;
	}
	public void setN1(float n1) {
		this.n1 = (n1 >= 0) ? n1 : -1;
	}
	public float getN2() {
		return n2;
	}
	public void setN2(float n2) {
		this.n2 = (n2 >= 0) ? n2 : -1;
	}
	public float getN3() {
		return n3;
	}
	public void setN3(float n3) {
		this.n3 = (n3 >= 0) ? n3 : -1;
	}
	public float getMedia() {
		return media;
	}

	public void calcMedia(){
		if(n3 < 0)
			media = (n1 >= 3 && n2 >= 3) ? (n1 + n2)/2 : 0; 
		else{
			media = (n1 > n2) ? n1 + n3 : n2 + n3;
			media /= 2;
		}
	}
	
	public void verificaMedia(){
		System.out.print("Média: " + media + ". ");
		if(media >= 5)
			System.out.println("Aluno aprovado!");
		else
			System.out.println("Aluno reprovado!");
	}
}
