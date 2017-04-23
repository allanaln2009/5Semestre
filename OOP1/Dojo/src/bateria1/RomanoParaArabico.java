package bateria1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanoParaArabico {
	private Map<String, Integer> mapa;
	private String num;

	public RomanoParaArabico(String num) {
		this.num = num;
		mapa = new HashMap<String, Integer>();
		mapa.put("I", 1);
		mapa.put("II", 2);
		mapa.put("III", 3);
		mapa.put("IV", 4);
		mapa.put("V", 5);
		mapa.put("VI", 6);
		mapa.put("VII", 7);
		mapa.put("VIII", 8);
		mapa.put("IX", 9);
		mapa.put("X", 10);
		mapa.put("L", 50);
		mapa.put("C", 100);
		mapa.put("D", 500);
		mapa.put("M", 1000);
	}

	private Integer retornarNumeroArabico(String letras) {
		String letSeguinte;
		String letAtual;
		int x;
		int numSeguinte;
		int numAtual;
		
		if(letras != null && !letras.isEmpty()){
			letras = letras.toUpperCase();
			Integer numero = mapa.get(letras); // verifica se tem numero pronto
			if(numero == null){
				numero = 0;
				validaLetras(letras);
				x = 0;
				while(x < letras.length()){
					letAtual = letras.charAt(x) + "";
					if(mapa.containsKey(letAtual)){
						x++;
						numAtual = mapa.get(letAtual);
						if(x == letras.length()) // ultima letra
							numero += numAtual;
						else{ // letra seguinte
							letSeguinte = letras.charAt(x) + "";
							numSeguinte = mapa.get(letSeguinte);
							if(numSeguinte > numAtual){
								numero += (numSeguinte - numAtual);
								x++;
							}else
								numero += numAtual;
						}
					}else
						throw new NumberFormatException("Caracteres inválidos.");
				}
			}
			return numero;
		}
		return null;
	}
	private void validaLetras(String letras) {
		Pattern p = Pattern
				.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		Matcher m = p.matcher(letras);
		if(!m.matches())
			throw new NumberFormatException("Caracteres inválidos.");
	}

	@Override
	public String toString() {
		return this.retornarNumeroArabico(num) + "";
	}
}
