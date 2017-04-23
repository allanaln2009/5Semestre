package bateria3;

public class Mapa {
	private static String[][] area;
	private static int atingido = 0;

	public Mapa(String[][] dadosArea) {
		super();
		area = new String[7][8]; //7 linhas; 8 colunas;
		area = dadosArea;
		mapa("inicializa");
	}
	
	void mapa(String acao) {
		String mapa = "";
		for(int i = 0; i < area.length; i++){
			for(int k = 0; k < area[i].length; k++){
				if(acao == "expande_fumaca")
					expandeFumaca(i, k);
				else if(acao == "desenha_mapa")
					mapa += area[i][k] + " ";
				else if(acao == "inicializa" && area[i][k] == null)
					area[i][k] = ".";
			}
			mapa += (acao == "desenha_mapa") ? "\n" : "";
		}
		if(acao == "expande_fumaca"){
			removeSimbTemp(); // remove underlines temporários
			System.out.println(atingido + " aeroporto(s) atingidos.");
			atingido = 0;
		}
		System.out.print(mapa);
	}
	private static void expandeFumaca(int i, int k) {
		if(area[i][k] == "*"){ // verifica se posição é um ponto válido para expandir
			try{
				if(area[i][(k - 1)] != "*"){
					atingido += (area[i][(k - 1)] == "A") ? 1 : 0; 
					area[i][(k - 1)] = "_"; // marca temporariamente campo a esquerda 
				}
			}catch(Exception e){}
			try{
				if(area[i][(k + 1)] != "*"){
					atingido += (area[i][(k + 1)] == "A") ? 1 : 0;
					area[i][(k + 1)] = "_"; // marca temporariamente campo a direito
				}
			}catch(Exception e){}
			try{
				if(area[(i - 1)][k] != "*"){
					atingido += (area[i - 1][k] == "A") ? 1 : 0;
					area[(i - 1)][k] = "_"; // marca temporariamente campo a baixo
				}
			}catch(Exception e){}
			try{
				if(area[(i + 1)][k] != "*"){
					atingido += (area[i + 1][k] == "A") ? 1 : 0;
					area[(i + 1)][k] = "_"; // marca temporariamente campo a cima
				}
			}catch(Exception e){}
		}
	}
	private static void removeSimbTemp() { // remove underlines e os torna novos pontos de expansão
		for(int i = 0; i < area.length; i++){
			for(int j = 0; j < area[i].length; j++){
				if(area[i][j] == "_"){
					area[i][j] = "*";
				}
			}
		}
	}
}
