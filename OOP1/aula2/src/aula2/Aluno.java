package aula2; // Exerc�cio 1

import java.util.Date;

import aula3.CfgGeral;

public class Aluno {
	private String ra; // O registro acad�mico n�o cont�m necessariamente apenas n�meros
	private String nome; // Armazenar� o nome do aluno
	private Date dtNasc;
	private int idCurso; // Para busca do curso do aluno, ser� usado um c�digo identificador
	private int semestre; // O semestre em quest�o ser� representado por um inteiro
	private float[] notas = new float[4];

	// Getter e setter de notas
	public float[] getNotas() {
		return notas;
	}
	public void setNotas(float[] notas) {
		this.notas = notas;
	}
	
	// Getter e setter RA
	public String getRa(){ // M�todo para obter 'ra' externamente
		return ra;
	}
	public void setRa(String ra){ // M�todo para atribuir valor a 'ra' externamente
		ra = ra.replaceAll("[^0-9]", "");
		if (ra.length() != 10){ // Verifica se o RA cont�m 10 digitos
			System.out.println("O RA " + ra + " n�o � v�lido."); // Mensagem de erro
			return;
		}else{
			String temp = determinaNomeNaFrase(primeiroNome(), 2); // define se nome vai aparecer na frase
			this.ra = "FA3." + ra; // Concatena prefixo da unidade ao RA antes de atribuir � mem�ria
			System.out.println("O RA " + this.ra + " foi atribu�do ao aluno" +  temp); // Mensagem de sucesso
		}
	}
	
	// Getter e setter nome
	public String getNome(){ // M�todo para obter 'nome' externamente
		return nome;
	}
	public void setNome(String nome){ // M�todo para atribuir valor a 'nome' externamente
		nome = CfgGeral.trataNome(nome);
		if (nome != null){ // verifica se o nome foi validado
			this.nome = nome;
			System.out.println("O aluno " + this.nome + " foi inserido com sucesso."); // Mensagem de sucesso
		}
	}
	
	// Getter e setter dtNasc
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	// Getter e setter idCurso
	public int getIdCurso(){
		//System.out.println("[" + idCurso + "] " + cursos[idCurso]); // para testar
		return idCurso;
	}
	public void setIdCurso(int idCurso){ // M�todo para atribuir valor a 'idCurso' externamente
		this.idCurso = Curso.validaCurso(idCurso);
		if(this.idCurso != 0){
			String temp = determinaNomeNaFrase(primeiroNome(), 1); // define se nome vai aparecer na frase
			System.out.println("Voc� acaba de colocar o aluno" + temp + "no curso " + Curso.getCurso(idCurso) + "."); // Mensagem de sucesso
		}
	}
	
	// Getter e setter Semestre
	public int getSemestre(){ // M�todo para obter 'semestre' externamente
		return semestre;
	}
	public void setSemestre(int semestre){ // M�todo para atribuir valor a 'semestre' externamente
		if (semestre < 1){
			System.out.println("Insira um semestre v�lido.");
			return;
		}
		String temp = determinaNomeNaFrase(primeiroNome(), 1); // define se nome do aluno vai aparecer na frase
		String temp2 = determinaNomeNaFrase(Curso.getCurso(getIdCurso()), 2); // define se nome do curso vai aparecer na frase
		if (temp2.length() > 2){
			temp2 = " de" + temp2;
		}
		this.semestre = semestre;
		System.out.println("Voc� acaba de colocar o aluno" + temp + "no " + this.semestre + "� semestre" + temp2); // Mensagem de sucesso
	}
	
	private String primeiroNome(){
		String nome = this.nome; // pega atributo nome
		String primeiroNome; // vari�vel que armazenar� o primeiro nome
		if (nome == null){ // verifica se o atributo n�o est� vazio 
			//System.out.println("N�o � poss�vel obter o primeiro nome, pois o atributo ainda n�o foi setado."); // mensagem de erro
			return ""; // retorna valor em branco, uma vez que n�o foi inserido um nome no objeto
		}else{
			String arrTemp[] = new String[1]; 
			arrTemp = nome.split(" "); // separa os nomes presentes no nome do aluno por espa�o
			primeiroNome = arrTemp[0]; // obtem primeiro nome
		}
		//System.out.println("Primeiro nome: " + primeiroNome); // mensagem de sucesso (para confer�ncia de dados apenas)
		return primeiroNome; // retorna primeiro nome do aluno, caso houver um
	}
	
	private String determinaNomeNaFrase(String palavra, int tipo){
		String temp = palavra; // pega nome se houver algo no atributo
		if (temp.isEmpty()){ // verifica se atributo est� vazio
			if (tipo == 2)
				return "."; // n�o exibir� o nome no fim da frase
			else{
				return " "; // n�o exibir� o nome no meio frase
			}
		}
		if(tipo == 1){
			temp = " " + temp + " "; // exibir� o nome no meio da frase
		}else if(tipo == 2){
			temp = " " + temp + "."; // exibir� o nome no fim da frase
		}
		return temp;
		// N�o quero ser o cara que vai cuidar da gram�tica se um dia essa solu��o for traduzida para idiomas mais amplos
	}
}
