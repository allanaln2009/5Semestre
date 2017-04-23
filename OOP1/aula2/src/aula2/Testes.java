package aula2;
public class Testes {
	public static void main(String[] args) {
		/**
		 * O código a seguir apresenta comentários que são os resultados de suas respectivas linhas de execução.
		 */
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		Aluno a4 = new Aluno();
		
		a1.setNome("     Állan Lima da Cunha"); //O aluno Állan Lima da Cunha foi inserido com sucesso.
		a1.setIdCurso(2); // Você acaba de colocar o aluno Állan no curso Ciência da Computação.
		/*// atribuições e resultados na respectiva ordem de execução
		a1.setIdCurso(0); // O ID 0 não é um curso válido.
		a1.setIdCurso(1); //Você acaba de colocar o aluno Állan no curso Análise de Sistemas. 
		a1.setIdCurso(5); //Você acaba de colocar o aluno Állan no curso Sistemas de Internet.
		a1.setIdCurso(6); //O ID 6 não é um curso válido.
		a1.setRa("993001157"); //O RA 993001157 não é válido.
		a1.setRa("99300115722"); //O RA 99300115722 não é válido.
		*/
		a1.setRa("9930011572"); //O RA FA3.9930011572 foi atribuído ao aluno Állan.
		a1.setSemestre(5); //Você acaba de colocar o aluno Állan no 5º semestre Ciência da Computação.
		/*
		System.out.println(a1.getIdCurso()); //2
		System.out.println(a1.getRa()); //FA3.9930011572
		System.out.println(a1.getNome()); //Állan Lima da Cunha
		System.out.println(a1.getSemestre()); //5
		*/
		
		// Teste sem atribuir nome antes 
		a2.setIdCurso(2); //Você acaba de colocar o aluno no curso Ciência da Computação.
		a2.setRa("9930011572"); // O RA FA3.9930011572 foi atribuído ao aluno.
		a2.setSemestre(5); //Você acaba de colocar o aluno no 5º semestre de Ciência da Computação.
		
		// Teste sem atribuir curso antes
		a3.setSemestre(5); //Você acaba de colocar o aluno no 5º semestre.

		// Teste com nome atribuido, mas sem curso definido 
		a4.setNome("Állan Lima da Cunha"); //O aluno Állan Lima foi inserido com sucesso.
		a4.setSemestre(5); //Você acaba de colocar o aluno Állan no 5º semestre.
	}
}