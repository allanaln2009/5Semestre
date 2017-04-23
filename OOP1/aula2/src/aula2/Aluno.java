package aula2; // Exercício 1

import java.util.Date;

import aula3.CfgGeral;

public class Aluno {
	private String ra; // O registro acadêmico não contém necessariamente apenas números
	private String nome; // Armazenará o nome do aluno
	private Date dtNasc;
	private int idCurso; // Para busca do curso do aluno, será usado um código identificador
	private int semestre; // O semestre em questão será representado por um inteiro
	private float[] notas = new float[4];

	// Getter e setter de notas
	public float[] getNotas() {
		return notas;
	}
	public void setNotas(float[] notas) {
		this.notas = notas;
	}
	
	// Getter e setter RA
	public String getRa(){ // Método para obter 'ra' externamente
		return ra;
	}
	public void setRa(String ra){ // Método para atribuir valor a 'ra' externamente
		ra = ra.replaceAll("[^0-9]", "");
		if (ra.length() != 10){ // Verifica se o RA contém 10 digitos
			System.out.println("O RA " + ra + " não é válido."); // Mensagem de erro
			return;
		}else{
			String temp = determinaNomeNaFrase(primeiroNome(), 2); // define se nome vai aparecer na frase
			this.ra = "FA3." + ra; // Concatena prefixo da unidade ao RA antes de atribuir à memória
			System.out.println("O RA " + this.ra + " foi atribuído ao aluno" +  temp); // Mensagem de sucesso
		}
	}
	
	// Getter e setter nome
	public String getNome(){ // Método para obter 'nome' externamente
		return nome;
	}
	public void setNome(String nome){ // Método para atribuir valor a 'nome' externamente
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
	public void setIdCurso(int idCurso){ // Método para atribuir valor a 'idCurso' externamente
		this.idCurso = Curso.validaCurso(idCurso);
		if(this.idCurso != 0){
			String temp = determinaNomeNaFrase(primeiroNome(), 1); // define se nome vai aparecer na frase
			System.out.println("Você acaba de colocar o aluno" + temp + "no curso " + Curso.getCurso(idCurso) + "."); // Mensagem de sucesso
		}
	}
	
	// Getter e setter Semestre
	public int getSemestre(){ // Método para obter 'semestre' externamente
		return semestre;
	}
	public void setSemestre(int semestre){ // Método para atribuir valor a 'semestre' externamente
		if (semestre < 1){
			System.out.println("Insira um semestre válido.");
			return;
		}
		String temp = determinaNomeNaFrase(primeiroNome(), 1); // define se nome do aluno vai aparecer na frase
		String temp2 = determinaNomeNaFrase(Curso.getCurso(getIdCurso()), 2); // define se nome do curso vai aparecer na frase
		if (temp2.length() > 2){
			temp2 = " de" + temp2;
		}
		this.semestre = semestre;
		System.out.println("Você acaba de colocar o aluno" + temp + "no " + this.semestre + "º semestre" + temp2); // Mensagem de sucesso
	}
	
	private String primeiroNome(){
		String nome = this.nome; // pega atributo nome
		String primeiroNome; // variável que armazenará o primeiro nome
		if (nome == null){ // verifica se o atributo não está vazio 
			//System.out.println("Não é possível obter o primeiro nome, pois o atributo ainda não foi setado."); // mensagem de erro
			return ""; // retorna valor em branco, uma vez que não foi inserido um nome no objeto
		}else{
			String arrTemp[] = new String[1]; 
			arrTemp = nome.split(" "); // separa os nomes presentes no nome do aluno por espaço
			primeiroNome = arrTemp[0]; // obtem primeiro nome
		}
		//System.out.println("Primeiro nome: " + primeiroNome); // mensagem de sucesso (para conferência de dados apenas)
		return primeiroNome; // retorna primeiro nome do aluno, caso houver um
	}
	
	private String determinaNomeNaFrase(String palavra, int tipo){
		String temp = palavra; // pega nome se houver algo no atributo
		if (temp.isEmpty()){ // verifica se atributo está vazio
			if (tipo == 2)
				return "."; // não exibirá o nome no fim da frase
			else{
				return " "; // não exibirá o nome no meio frase
			}
		}
		if(tipo == 1){
			temp = " " + temp + " "; // exibirá o nome no meio da frase
		}else if(tipo == 2){
			temp = " " + temp + "."; // exibirá o nome no fim da frase
		}
		return temp;
		// Não quero ser o cara que vai cuidar da gramática se um dia essa solução for traduzida para idiomas mais amplos
	}
}
