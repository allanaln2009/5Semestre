package aula2;
public class Curso {
	private static String[] cursos = { // Lista de cursos
			"", // ID 0 não existe
		    "Análise de Sistemas",
		    "Ciência da Computação",
		    "Engenharia de Software",
		    "Engenharia Elétrica",
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
			System.out.println("O ID " + idCurso + " não é um curso válido."); // Exibe erro
			return 0;
		}
		return idCurso;
	}
}
