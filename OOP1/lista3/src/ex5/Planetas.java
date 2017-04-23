package ex5;

public class Planetas {
	private float[] gravidades = {0.37f, 0.88f, 0.38f, 2.64f, 1.15f, 1.17f};
	private String[] planetas = {"Mercúrio", "Vênus", "Marte", "Júpiter", "Saturno", "Urano"};
	
	public String[] getPlanetas() {
		return planetas;
	}
	
	public float calcula(int index, float peso){
		return (peso/10)*gravidades[index];
	}
}
