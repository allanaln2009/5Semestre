import java.util.Date;

public class Produto {
	private int codigo;
	private String descricao;
	private String fornecedor;
	private Date dt_validade;
	
	public Produto(int codigo, String descricao, String fornecedor,
			Date dt_validade) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.fornecedor = fornecedor;
		this.dt_validade = dt_validade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDt_validade() {
		return dt_validade;
	}

	public void setDt_validade(Date dt_validade) {
		this.dt_validade = dt_validade;
	}
	
}
