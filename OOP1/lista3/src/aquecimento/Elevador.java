package aquecimento;

public class Elevador {
	
	private int andares;
	private int andAtual;
	private int capacidade;
	private int pessoas;
	
	public Elevador(int andares, int capacidade) {
		super();
		this.andares = andares;
		this.capacidade = capacidade;
		this.andAtual = 0;
	}
	public int getAndares() {
		return andares;
	}
	public void setAndares(int andares) {
		this.andares = andares;
	}
	public int getAndAtual() {
		return andAtual;
	}
	public void setAndAtual(int andAtual) {
		this.andAtual = andAtual;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getPessoas() {
		return pessoas;
	}
	public void setPessoas(int pessoas) {
		this.pessoas = pessoas;
	}
	
	
	public void entrada(){
		if(pessoas <= capacidade){
			pessoas++;
		}
	}
	public void sai(){
		if(pessoas > 0){
			pessoas--;
		}
	}
	public void sobe(){
		if(andAtual < andares){
			andAtual++;
		}
	}
	public void desce(){
		if(andAtual > 0){
			andAtual--;
		}
	}
}
