public class Estoque {
	private Produto[] produtos;
	private int[] qtd_produtos;

	public Estoque() {
		super();
		this.produtos = new Produto[50];
		this.qtd_produtos = new int[50];
	}

	public Produto getProduto(int posicao) {
		return produtos[posicao];
	}

	public void addProduto(Produto produto, int quantidade, int posicao) {
		this.produtos[posicao] = produto;
		this.qtd_produtos[posicao] = quantidade;
	}

	public int getQtd(int posicao) {
		return qtd_produtos[posicao];
	}

	public void setQtd(int qtd, int posicao) {
		this.qtd_produtos[posicao] = qtd;
	}

	public int getSize() {
		return this.qtd_produtos.length;
	}
}
