package aula2;
public class Curso {
	private static String[] cursos = { // Lista de cursos
			"", // ID 0 n�o existe
		    "An�lise de Sistemas",
		    "Ci�ncia da Computa��o",
		    "Engenharia de Software",
		    "Engenharia El�trica",
		    "Sistemas de Internet"
	};

	public static String getCurso(int id) {
		return cursos[id];
	}
	/*
	public static void setCurso(String[] cursos) {
		Curso.cursos = cursos;
	}
	*/
	public static int qtdCursos() {
		return cursos.length;
	}
	public static int validaCurso(int idCurso){
		if (idCurso <= 0 || idCurso > (cursos.length - 1)){ // Verifica se o ID existe na lista
			System.out.println("O ID " + idCurso + " n�o � um curso v�lido."); // Exibe erro
			return 0;
		}
		return idCurso;
	}
}
