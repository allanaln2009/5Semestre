import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static Scanner leitor;
	static Estoque estoque;
	static Produto produto;
	static int codigoAtual;
	static SimpleDateFormat dataMasc;
	static Date date;

	public static void main(String[] args) {
		leitor = new Scanner(System.in);
		estoque = new Estoque();
		codigoAtual = 0;
		dataMasc = new SimpleDateFormat("ddMMyyyy");
		
		produto = new Produto(codigoAtual, "descricao", "fornecedor", pegaDtStr("01012017"));
		estoque.addProduto(produto, 50, codigoAtual);
		codigoAtual++;
		produto = new Produto(codigoAtual, "descricao1", "fornecedor1", pegaDtStr("01012018"));
		estoque.addProduto(produto, 150, codigoAtual);
		codigoAtual++;
		produto = new Produto(codigoAtual, "descricao2", "fornecedor2", pegaDtStr("01012020"));
		estoque.addProduto(produto, 5, codigoAtual);
		codigoAtual++;
		
		int opcao = 0;
		while(opcao == 0){
			opcao = desenhaMenu();
			if(opcao == 1){
				cadastraProduto();
				opcao = 0;
			}else if(opcao == 2){
				listaEstoque();
				opcao = 0;
			}else if(opcao == 3){
				System.exit(0);
			}else{
				System.out.println("Opção inválida.");
			}
		}
	}

	private static void listaEstoque() {
		Produto produto = null;
		int qtd;
		for(int i = 0; i < estoque.getSize(); i++){
			try{
				produto = estoque.getProduto(i);
			}catch(NullPointerException e){
				continue;
			}
			if(produto != null){
				qtd = estoque.getQtd(i);
				System.out.println(produto.getCodigo() + "\t"
						+ produto.getDescricao() + "\t\t"
						+ produto.getFornecedor() + "\tVal: "
						+ devolveDtStr(produto.getDt_validade()) + "\tQtd: " + qtd);
			}
		}
		leitor.nextLine();
	}

	private static void cadastraProduto() {
		String descricao = "";
		while(descricao.isEmpty()){
			System.out.print("Informe a descrição do produto " + codigoAtual
					+ ": ");
			descricao = leitor.nextLine();
		}

		String fornecedor = "";
		while(fornecedor.isEmpty()){
			System.out.print("Informe o fornecedor do produto: ");
			fornecedor = leitor.nextLine();
		}

		Date dt_validade = null;
		while(dt_validade == null){
			System.out.print("Informe a data de validade do produto: ");
			try{
				dt_validade = pegaDtStr(leitor.nextLine());
			}catch(Exception e){
				System.out.println("Data inválida. Siga o padrão DDMMAAAA");
				continue;
			}
		}

		int quantidade = -1;
		while(quantidade < 0){
			System.out.print("Informe a quantidade em estoque do produto: ");
			try{
				quantidade = leitor.nextInt();
			}catch(Exception e){
				leitor.nextLine();
				System.out.println("Quantidade inválida.");
				continue;
			}
			leitor.nextLine();
			if(quantidade < 0){
				System.out.println("Quantidade inválida.");
				continue;
			}
		}
		produto = new Produto(codigoAtual, descricao, fornecedor, dt_validade);
		estoque.addProduto(produto, quantidade, codigoAtual);
	}

	private static int desenhaMenu() {
		int opcao = 0;
		System.out
				.println("Escolha uma opção:\n 1.Cadastrar produto\n 2.Visualizar estoque\n 3.Sair");
		try{
			opcao = leitor.nextInt();
		}catch(Exception e){
			leitor.nextLine();
			System.out.println("Opção inválida.");
		}
		leitor.nextLine();
		return opcao;
	}

	private static Date pegaDtStr(String dataStr) {
		dataStr = dataStr.replaceAll("[^0-9]", "");
		try{
			date = dataMasc.parse(dataStr);
		}catch(Exception e){
			System.out.println("Digite uma data válida no formato DDMMYYYY");
			return null;
		}
		return date;
	}

	public static String devolveDtStr(Date data) {
		String dataStr;
		try{
			dataStr = dataMasc.format(data);
		}catch(Exception e){
			return null;
		}
		return dataStr;
	}
}
