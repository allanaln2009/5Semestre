package lista2;

public class Contato {
	private int id;
	private String nome;
	private String email;

	public Contato(int id, String nome, String email) {
		super();
		this.id = id;
		this.nome = Agenda.trataNome(nome);
		this.email = email.toLowerCase();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
