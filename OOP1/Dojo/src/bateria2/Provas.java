package bateria2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Provas {
	private String suspeito = "";
	private String local = "";
	private String arma = "";

	private List<String> nomes = new ArrayList<String>();
	private List<String> locais = new ArrayList<String>();
	private List<String> armas = new ArrayList<String>();

	public Provas() {
		super();
		defineNomes();
		sortear();
		this.suspeito = nomes.get(0);
		this.local = locais.get(0);
		this.arma = armas.get(0);
		//System.out.println(suspeito + " - " + local + " - " + arma);
		defineNomes(); //volta listas a ordem normal
	}

	public List<String> getNomes() {
		return nomes;
	}

	public List<String> getLocais() {
		return locais;
	}

	public List<String> getArmas() {
		return armas;
	}

	private void defineNomes() {
		nomes.clear();
		nomes.add("Charles B. Abbage");
		nomes.add("Donald Duck Knuth");
		nomes.add("Ada L. Ovelace");
		nomes.add("Alan T. Uring");
		nomes.add("Ivar J. Acobson");
		nomes.add("Ras Mus Ler Dorf");

		locais.clear();
		locais.add("Redmond");
		locais.add("Palo Alto");
		locais.add("San Francisco");
		locais.add("Tokio");
		locais.add("Restaurante no Fim do Universo");
		locais.add("Sao Paulo");
		locais.add("Cupertino");
		locais.add("Helsinki");
		locais.add("Maida Vale");
		locais.add("Toronto");

		armas.clear();
		armas.add("Peixeira");
		armas.add("DynaTAC 8000X");
		armas.add("Trezoitão");
		armas.add("Trebuchet");
		armas.add("Maçã");
		armas.add("Gládio");
	}

	public String compara(String suspeito_, String local_, String arma_) {
		int[] acertos = new int[3]; // apesar do nome, conterá os resultados (erros e acertos)
		if(suspeito_.contains(suspeito)){
			acertos[0] = 0;
		}else{
			acertos[0] = 1;
		}

		if(local_.equals(local)){
			acertos[1] = 0;
		}else{
			acertos[1] = 2;
		}

		if(arma_.equals(arma)){
			acertos[2] = 0;
		}else{
			acertos[2] = 3;
		}
		
		int cont = 0;
		Integer[] erros = new Integer[3];
		for(int i = 0; i < acertos.length; i++){
			if(acertos[i] != 0){ // zeros não seram exibidos, portanto, não são salvos
				erros[cont] = acertos[i];
				cont++;
			}
		}

		Random r = new Random();
		int c;
		while(true){
			c = r.nextInt(3);
			if(erros[c] != null){
				return erros[c] + ""; // aleatoriamente mostra um dos erros 
			}else if (erros[0] == null && erros[1] == null && erros[2] == null){
				return "0"; // acertou tudo
			}
		}
	}
	private void sortear() { //embaralha nomes
		Collections.shuffle(nomes);
		Collections.shuffle(locais);
		Collections.shuffle(armas);
	}

}
