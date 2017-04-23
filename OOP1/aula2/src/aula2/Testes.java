package aula2;
public class Testes {
	public static void main(String[] args) {
		/**
		 * O c�digo a seguir apresenta coment�rios que s�o os resultados de suas respectivas linhas de execu��o.
		 */
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		Aluno a4 = new Aluno();
		
		a1.setNome("     �llan Lima da Cunha"); //O aluno �llan Lima da Cunha foi inserido com sucesso.
		a1.setIdCurso(2); // Voc� acaba de colocar o aluno �llan no curso Ci�ncia da Computa��o.
		/*// atribui��es e resultados na respectiva ordem de execu��o
		a1.setIdCurso(0); // O ID 0 n�o � um curso v�lido.
		a1.setIdCurso(1); //Voc� acaba de colocar o aluno �llan no curso An�lise de Sistemas. 
		a1.setIdCurso(5); //Voc� acaba de colocar o aluno �llan no curso Sistemas de Internet.
		a1.setIdCurso(6); //O ID 6 n�o � um curso v�lido.
		a1.setRa("993001157"); //O RA 993001157 n�o � v�lido.
		a1.setRa("99300115722"); //O RA 99300115722 n�o � v�lido.
		*/
		a1.setRa("9930011572"); //O RA FA3.9930011572 foi atribu�do ao aluno �llan.
		a1.setSemestre(5); //Voc� acaba de colocar o aluno �llan no 5� semestre Ci�ncia da Computa��o.
		/*
		System.out.println(a1.getIdCurso()); //2
		System.out.println(a1.getRa()); //FA3.9930011572
		System.out.println(a1.getNome()); //�llan Lima da Cunha
		System.out.println(a1.getSemestre()); //5
		*/
		
		// Teste sem atribuir nome antes 
		a2.setIdCurso(2); //Voc� acaba de colocar o aluno no curso Ci�ncia da Computa��o.
		a2.setRa("9930011572"); // O RA FA3.9930011572 foi atribu�do ao aluno.
		a2.setSemestre(5); //Voc� acaba de colocar o aluno no 5� semestre de Ci�ncia da Computa��o.
		
		// Teste sem atribuir curso antes
		a3.setSemestre(5); //Voc� acaba de colocar o aluno no 5� semestre.

		// Teste com nome atribuido, mas sem curso definido 
		a4.setNome("�llan Lima da Cunha"); //O aluno �llan Lima foi inserido com sucesso.
		a4.setSemestre(5); //Voc� acaba de colocar o aluno �llan no 5� semestre.
	}
}