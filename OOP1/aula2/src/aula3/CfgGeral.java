package aula3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CfgGeral {
	private static SimpleDateFormat dtMasc = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dtMasc1 = new SimpleDateFormat("ddMMyyyy");
	private static Date dt; // data a ser devolvida
	private static Date dtSistema = new Date();
	
	/*public CfgGeral(){
		// mascaras padrões
		dtMasc = new SimpleDateFormat("dd/mm/yyyy");
		dtMasc1 = new SimpleDateFormat("ddmmyyyy");
		// data do sistema
		dtSistema = new Date();
	}*/
	
	public static Date getDtSistema() {
		return dtSistema;
	}

	public static Date pegaDtStr(String dtString){
		dtString = dtString.replaceAll("[^0-9]", "");
		try{
			dt = dtMasc1.parse(dtString); 
		}catch(ParseException e1){
			//e1.printStackTrace();
			System.out.println("Digite uma data válida no formato DDMMYYYY");
			return null;
		}
		return dt;
	}
	public static String devolveDtStr(Date data){
		String dtStr;
		try {
			dtStr = dtMasc.format(data); //gera string da data com a mascara
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		return dtStr;
	}
	public static String trataNome(String nome){
		String nomePronto = "";
		if (nome.length() < 9 || nome == null){ // verifica se o nome possui menos que 10 digitos
			System.out.println("Escreva o nome completo.");
			return null;
		}else{
			nome = nome.toLowerCase(); // deixa tudo minusculo
			nome = nome.trim(); // Retira espaços em branco para evitar problemas na separação
			String vetNomes[] = nome.split(" "); 
			//vetNomes = nome.split(" ");
			for (int i = 0; i < vetNomes.length; i++) {
				vetNomes[i] = vetNomes[i].substring(0,1).toUpperCase().concat(vetNomes[i].substring(1)).replaceAll("[^a-zA-Z]", "");
				// A linha a cima pega o nome separado, remove simbolos não alfabéticos altera o case da primeira letra e concatena com o restante das letras 
				nomePronto = nomePronto + " " + vetNomes[i]; 
			}
		}
		return nomePronto.trim();
	}
}
