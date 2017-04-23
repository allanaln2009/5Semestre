package bateria2;

public class Main {
	public static void main(String[] args) {
		Provas a = new Provas();
		String nome, local, arma;
		for(int i = 0; i < 6; i++){
			nome = a.getNomes().get(i);
			local = a.getLocais().get(i);
			arma = a.getArmas().get(i);
			System.out.print(nome + ", " + local + ", " + arma + ": ");
			System.out.println(a.compara(nome, local, arma));
		}
	}
}
