package ATPS;

import java.util.ArrayList;

public class ClasseA extends UnidadeConsumidora{
	//alta tensão
	private ArrayList<Integer> leiturasP; // consumo em horario de pico

	public ClasseA(Integer cod, String nome, String logra, String end,
			String num, String bairro, String cidade, String uf) {
		super(cod, nome, logra, end, num, bairro, cidade, uf);
	}
	
	public ArrayList<Integer> getLeiturasP() {
		return leiturasP;
	}
	public void setLeiturasP(ArrayList<Integer> leiturasP) {
		this.leiturasP = leiturasP;
	}
}
