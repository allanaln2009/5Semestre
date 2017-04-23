package ATPS;

import java.util.ArrayList;
import java.util.Date;

public class UnidadeConsumidora {
	private Integer cod;
	private String nome;
	private String logra;
	private String end;
	private String num;
	private String bairro;
	private String cidade;
	private String uf;
	//private String cep;
	private ArrayList<Integer> leiturasN; // leitura para uso convencional
	
	private ArrayList<Date> dtLeituras;
	
	public UnidadeConsumidora(Integer cod, String nome, String logra, String end,
			String num, String bairro, String cidade, String uf) {
		//super();
		this.cod = cod;
		this.nome = nome;//aula3.CfgGeral.trataNome(nome);
		this.logra = logra;
		this.end = end;//aula3.CfgGeral.trataNome(end);
		this.num = num;
		this.bairro = bairro;//aula3.CfgGeral.trataNome(bairro);
		this.cidade = cidade;//aula3.CfgGeral.trataNome(cidade);
		this.uf = trataUF(uf);
	}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogra() {
		return logra;
	}
	public void setLogra(String logra) {
		this.logra = logra;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	/*public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}*/
	public ArrayList<Integer> getLeiturasN() {
		return leiturasN;
	}
	public void setLeiturasN(ArrayList<Integer> leiturasN) {
		this.leiturasN = leiturasN;
	}
	public ArrayList<Date> getDtLeituras() {
		return dtLeituras;
	}
	public void setDtLeituras(ArrayList<Date> datasLeituras) {
		this.dtLeituras = datasLeituras;
	}
	
	private String trataUF(String uf){
		String[] nomes = uf.split(" "); 
		if(nomes.length > 2){
			uf = nomes[0].substring(0,1) + nomes[nomes.length].substring(0,1);
			//vetNomes[i] = vetNomes[i].substring(0,1).toUpperCase().concat(vetNomes[i].substring(1)).replaceAll("[^a-zA-Z]", "");
		}else{
			try{
				uf = uf.substring(0, 2);
			}catch(StringIndexOutOfBoundsException e){
			}
		}
		return uf.toUpperCase();
	}
}
