package ATPS;

import java.util.Collections;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	public static Integer codigoA, codigoB;
	static int opcao;
	static int classe;
	static Scanner leitor;
	static ArrayList<ClasseA> classeA;
	static ArrayList<ClasseB> classeB;
	static ArrayList<Integer> valoresLeiturasN;
	static ArrayList<Integer> valoresLeiturasP;
	static ArrayList<Date> datasLeituras;
	static float taxa;
	static float taxaP;
	
	
	public static void main(String[] args) {
		taxa = 0.34f;
		taxaP = taxa * 1.3f;
		
		classeA = new ArrayList<ClasseA>(); //	lista de clientes de Alta tensão
		classeB = new ArrayList<ClasseB>();//	lista de clientes de Baixa tensão
		codigoA = 0;					  //	código inicial para inserção de clientes de classe A
		codigoB = 0; 					 //		código inicial para inserção de clientes de classe B
		leitor = new Scanner(System.in);//		leitor de entradas do usuário
		opcao = 0;					   //		variável para lidar com saída de loop e entradas do usuário
		/*//força inserção de clientes (para teste) função ao final do código
		insA();
		insB();
		*/
		while(opcao != 3){
			opcao = menuPrincipal();
		}
	}
	public static int menuPrincipal(){ // Principal
		System.out.println("MENU PRINCIPAL");
		opcao = 0;
		while(opcao != 1 && opcao != 2 && opcao != 3){
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Unidade Consumidora");
			System.out.println("2 - Definir custo energético");
			System.out.println("3 - Sair");
			try{
				opcao = leitor.nextInt();
			}catch(InputMismatchException e){
				leitor.nextLine();
				System.out.println("Insira uma opção válida.");
				continue;
			}
			leitor.nextLine();
			if(opcao == 1){
				menuUC();
			}else if(opcao == 2){
				System.out.println("CUSTO KW/h");
				System.out.println("O custo atual é de R$ " + taxa + " por KW/h, para alterar o valor, " +
				"defina a nova tarifa." +
				"\nOu insira um valor negativo para voltar ao menu anterior sem efetuar alterações:"
				);
				float _taxa = 0;
				try{
					_taxa = leitor.nextFloat();
				}catch(InputMismatchException e){
					leitor.nextLine();
					System.out.println("Você não inseriu uma informação válida.");
					continue;
				}
				leitor.nextLine();
				if(_taxa > 0){
					System.out.println("A taxa passou de R$ " + taxa + " para R$ " + _taxa + ".");
					taxa = _taxa;
				}
			}
		}
		return opcao;
	}
	public static void menuUC(){ // menu referente a UCs
		opcao = 0;
		while(opcao != 4){
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar UC");
			System.out.println("2 - Cadastrar leituras");
			System.out.println("3 - Gerar faturas");
			System.out.println("4 - Voltar");
			try{
				opcao = leitor.nextInt();
			}catch(InputMismatchException e){
				leitor.nextLine();
				System.out.println("Insira uma opção válida.");
				continue;
			}
			leitor.nextLine();
			if(opcao == 1){
				telaCadUC("cadastro de unidades");
				cadastroUC(classe);
			}else if(opcao == 2){
				if(classeA.size() == 0 && classeB.size() == 0){
					System.out.println("Não há nenhum cadastro para preencher. Por favor, cadastre unidades antes de continuar.");
					pegaEnter();
				}else{
					telaCadUC("cadastro de leituras");
					cadastroLeitura(classe);
				}
			}else if(opcao == 3){
				if(classeA.size() == 0 && classeB.size() == 0){
					System.out.println("Não há nenhum cadastro para preencher. Por favor, cadastre unidades e atribua leituras antes de continuar.");
					pegaEnter();
				}else{
					telaCadUC("Gerador de faturas");
					geradorFaturas();
				}
			}
			classe = 0;
		}
		opcao = 0;
	}
	private static void telaCadUC(String titulo) { //desenha tela para cadastro de UCs, leituras e criação de faturas
		opcao = 0;
		while(opcao != 1 && opcao != 2 && opcao != 3){
			System.out.println(titulo.toUpperCase());
			System.out.println("Escolha uma opção:");
			System.out.println("1 - UC Classe A");
			System.out.println("2 - UC Classe B");
			System.out.println("3 - Voltar");
			try{
				opcao = leitor.nextInt();
			}catch(InputMismatchException e){
				leitor.nextLine();
				System.out.println("Insira uma opção válida.");
				continue;
			}
			leitor.nextLine();
			classe = opcao;
		}
		opcao = 0;
	}
	private static void cadastroUC(int classe) { // coleta informações para cadastro de cliente
		if(!(classe == 1 || classe == 2)){
			return;
		}
		
		Integer cod = null;
		String nome = "";
		String logra  = "";
		String end = "";
		String num = "";
		String bairro = "";
		String cidade = "";
		String uf = "";
		//String cep = "";
		
		System.out.print("Digite o nome do proprietário: ");
		while (nome.isEmpty()) {
			nome = leitor.nextLine();//.replaceAll("[^a-zA-z]", "");
		}
		/*System.out.print("Digite o nome do proprietário: ");
		while (logra.isEmpty()) {
			nome = leitor.nextLine().replaceAll("[^a-zA-z]", "");
		}*/
		System.out.print("Digite apenas o endereço: ");
		while (end.isEmpty()) {
			end = leitor.nextLine();
		}
		System.out.print("Número e letra: ");
		while (num.isEmpty()) {
			num = leitor.nextLine();
		}
		System.out.print("Bairro: ");
		while (bairro.isEmpty()) {
			bairro = leitor.nextLine();
		}
		System.out.print("Cidade: ");
		while (cidade.isEmpty()) {
			cidade = leitor.nextLine();
		}
		System.out.print("Estado (sigla): ");
		while (uf.isEmpty()) {
			uf = leitor.nextLine();
		}
		
		if(classe == 1){ // classe alta
			cod = codigoA;
			ClasseA cA = new ClasseA(cod, nome, logra, end, num, bairro, cidade, uf);
			classeA.add(cA);
			codigoA++;
		}else if(classe == 2){ // classe baixa
			cod = codigoB;
			ClasseB cB = new ClasseB(cod, nome, logra, end, num, bairro, cidade, uf);
			classeB.add(cB);
			codigoB++;
		}
		System.out.println("Unidade inserida!\nCódigo de unidade: " + (cod + 1));
		pegaEnter();
	}
	private static void cadastroLeitura(int classe) {
	// chama função responsável pela captura das informações, mas antes verifica se dados foram preenchidos 
		if(classe == 1){ // classe alta
			if(classeA.size() == 0){
				System.out.println("Não há UC's de Classe A.");
				pegaEnter();
				return;
			}
			int codigo = exibeInfo("a", "c"); // parametros para "classeA" e "cadastro", retorna código ou erro
			if(codigo == -2){ //código inexistente
				return;
			}
			pegaValorMedidor("a");
			classeA.get(codigo).setLeiturasN(valoresLeiturasN);
			classeA.get(codigo).setLeiturasP(valoresLeiturasP);
			classeA.get(codigo).setDtLeituras(datasLeituras);
		}else if(classe == 2){ // classe baixa
			if(classeB.size() == 0){
				System.out.println("Não há UC's de Classe B.");
				pegaEnter();
				return;
			}
			int codigo = exibeInfo("b", "c"); // parametros para "classeB" e "cadastro"
			if(codigo == -2){ //código inexistente
				return;
			}
			pegaValorMedidor("b");
			classeB.get(codigo).setLeiturasN(valoresLeiturasN);
			classeB.get(codigo).setDtLeituras(datasLeituras);
		}
	}
	private static void geradorFaturas() {
		if(classe == 1){ // classe alta
			if(classeA.size() == 0){
				System.out.println("Não há UC's de Classe A.");
				pegaEnter();
				return;
			}
			int codigo = exibeInfo("a", "f"); // parametros para "classeA" e "faturas"
			if(codigo == -2){
				return;
			}
			ArrayList<Integer> normal = classeA.get(codigo).getLeiturasN();
			ArrayList<Integer> pico = classeA.get(codigo).getLeiturasP();
			ArrayList<Date> datas = classeA.get(codigo).getDtLeituras();
			desenhaFatura(normal, pico, datas, codigo);
		}else if(classe == 2){ // classe baixa
			if(classeB.size() == 0){
				System.out.println("Não há UC's de Classe B.");
				pegaEnter();
				return;
			}
			int codigo = exibeInfo("b", "f"); // parametros para "classeA" e "faturas"
			if(codigo == -2){
				return;
			}
			ArrayList<Integer> normal = classeB.get(codigo).getLeiturasN();
			ArrayList<Integer> pico = null;
			ArrayList<Date> datas = classeB.get(codigo).getDtLeituras();
			desenhaFatura(normal, pico, datas, codigo);
		}
	}
	private static void desenhaFatura(ArrayList<Integer> normal, ArrayList<Integer> pico, ArrayList<Date> datas, int codigo) {
	// gera fatura de UC
		int tam = 0;
		try{
			if(pico == null){
				tam = classeB.get(codigo).getLeiturasN().size() - 1;
			}else{
				tam = classeA.get(codigo).getLeiturasN().size() - 1;
			}
		}catch(NullPointerException e){
			System.out.println("Você ainda não cadastrou leituras para este cliente.");
			pegaEnter();
			return;
		}catch(java.lang.IndexOutOfBoundsException e){
			System.out.println("Não há leituras cadastradas para gerar uma fatura...");
			pegaEnter();
			return;
		}
		//inverte as listas
		Collections.reverse(normal);
		try{
			Collections.reverse(pico);
		}catch(NullPointerException e){}
		Collections.reverse(datas);
		
		int v;
		if(pico == null){// identifica quem fez a chamada 
			v = 1; // classe B
		}else{
			v = 2; // classe A
		}
		
		Integer atualN = normal.get(tam); // leitura atual
		Integer anterN = normal.get(tam - 1); // leitura mes anterior
		
		Integer atualP; // leitura mes atual - horário de pico
		try{
			atualP = pico.get(tam);
		}catch(NullPointerException e){
			atualP = 0;
		}

		Integer anterP; // leitura mes anterior - horário de pico
		try{
			anterP = pico.get(tam - 1);
		}catch(NullPointerException e){
			anterP = 0;
		}
		
		Date dataAtual = datas.get(tam); // mes fatura atual
		Date dataAnter = datas.get(tam - 1); // mes fatura anterior
		
		// calcula consumo energético
		Integer usoKwN = calcDifKw(atualN, anterN); 
		Integer usoKwP = calcDifKw(atualP, anterP);

		//define custos
		float custoN = (usoKwN * taxa);
		float custoP = (usoKwP * taxaP);
		float valor = custoN + custoP;
		
		System.out
				.println("\n................................................."
						+ "\nLeitura anterior:" + "\n" + date2string(dataAnter)
						+ ":" + "\n\tDados leitura normal:             "
						+ anterN + " KW/h");
		if (v == 2) {
			System.out.print("\tEm horário de pico:               " + anterP
					+ " KW/h");
		}
		System.out.print("\n................................................."
				+ "\n................................................."
				+ "\nLeitura atual:" + "\n" + date2string(dataAtual)
				+ "\n\tMarcador normal:             " + atualN + " KW/h");
		if (v == 2) {
			System.out.print("\n\tMarcador horário de pico:    " + atualP
					+ " KW/h");
		}
		System.out.print("\n\n\tConsumo em horário normal:   " + usoKwN
				+ " KW/h" + "\n\t\t\t\t * R$ " + taxa + " = R$ " + custoN);
		if (v == 2) {
			System.out.print("\n\tConsumo em horário de pico:  " + usoKwP
					+ " KW/h" + "\n\t\t\t\t * R$ " + taxaP + " = R$ " + custoP);
		}
		System.out.print("\n\tTotal:                     R$ " + valor
				+ "\n................................................."
				+ "\n.................................................\n");
	}
	private static int exibeInfo(String classe, String tipo){ //exibe informações de UC de acordo com seu código
		int cod = 1;
		System.out.println("Digite o código da UC Classe " + classe.toUpperCase() + ": ");
		try{
			cod = leitor.nextInt();
		}catch(InputMismatchException e){
			leitor.nextLine();
			System.out.println("Digite um código válido.");
			return -2;
		}
		leitor.nextLine();
		ClasseA unidadeA = null;
		ClasseB unidadeB = null;
		try{
			if(classe == "a"){
				unidadeA = classeA.get(cod - 1);
			}else if(classe == "b"){
				unidadeB = classeB.get(cod - 1);
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("Ops... Parece que esse código ai não existe ainda.");
			pegaEnter();
			return -2;
		}
		if(classe == "a"){
			System.out.println("Código: " + (unidadeA.getCod()+1) + "\n" +
			"Proprietário: " + unidadeA.getNome() + "\n" +
			//"CEP: " + unidadeA.getCep() + "\n" +
			"Endereço: " + unidadeA.getLogra() + " " + unidadeA.getEnd() + ", " + unidadeA.getNum() + "\n" +
			"\t  " + unidadeA.getBairro() + ", " + unidadeA.getCidade() + " - " + unidadeA.getUf() 
			);
		}else if(classe == "b"){
			System.out.println("Código: " + (unidadeB.getCod()+1) + "\n" +
			"Proprietário: " + unidadeB.getNome() + "\n" +
			//"CEP: " + unidadeB.getCep() + "\n" +
			"Endereço: " + unidadeB.getLogra() + " " + unidadeB.getEnd() + ", " + unidadeB.getNum() + "\n" +
			"\t  " + unidadeB.getBairro() + ", " + unidadeB.getCidade() + " - " + unidadeB.getUf()
			);
		}
		return (cod-1);
	}
	private static void pegaValorMedidor(String classe) { // captura leituras de uso de energia
		valoresLeiturasN = new ArrayList<Integer>();
		valoresLeiturasP = new ArrayList<Integer>();
		datasLeituras = new ArrayList<Date>();
		Date dtAtual = new Date();
		int meses = 0;
		int x = 1;
		int x2 = 1;
		String mesAnt;
		String leituras;
		String[] separadas;
		opcao = 0;
		System.out.println("Digite os valores correspondentes aos períodos:\n Para finalizar a inserção, basta inserir um valor negativo.");
		while(opcao >= 0){
			mesAnt = (date2string(dtSubt(dtAtual, 0, meses, 0))).substring(3,10); //pega mes e ano da data atual e subtrai com base em "meses"
			System.out.print(" " + mesAnt + " - ");
			opcao = 1;
			while(opcao == 1){
				leituras = leitor.nextLine();
				if(leituras.contains("-")){
					opcao = -1; //encerra inserção
					x = -1;
					continue;
				}
				separadas = leituras.split(";");
				for (int i = 0; i < 2; i++) { // força retirada de letras
					try{
						//separadas[i] = separadas[i].replaceAll("[^0-9]", "");
						separadas[i] = separadas[i].replaceAll("[^0-9^-]", "");
					}catch(NumberFormatException e){
						separadas[i] = "0";
					}catch(ArrayIndexOutOfBoundsException e){
					}
				}
				try{
					x = Integer.parseInt(separadas[0]);
				}catch(NumberFormatException e){
					if(classe == "a"){
						System.out.print("Digite \"leitura normal;horário de pico\" para referência " + mesAnt + ": ");
						continue;
					}else{
						System.out.print("Digite \"leitura normal\" para referência " + mesAnt + ": ");
						continue;
					}
				}
				try{
					x2 = Integer.parseInt(separadas[1]);
				}catch(ArrayIndexOutOfBoundsException e){
					if(classe == "a"){
						System.out.print("Digite \"leitura normal;horário de pico\" para referência " + mesAnt + ": ");
						continue;
					}
				}catch(NumberFormatException e){
					if(classe == "a"){
						System.out.print("Digite \"leitura normal;horário de pico\" para referência " + mesAnt + ": ");
						continue;
					}
				}

				if(classe == "a"){
					if((x2 >= 0 && x2 <= 9999) && (x >= 0 && x <= 9999)){
						opcao = 0; //sai do loop de captura
						continue;
						// não pode continuar aqui porque x tem de ser validado
					}else if(x2 < 0  || x < 0){
						opcao = -1; //encerra inserção
						continue;
					}else{
						System.out.println("A leitura do horário de pico deve estar entre 0 e 9999.");
						continue;
					}
				}else if(classe == "b"){
					if(x >= 0 && x <= 9999){
						opcao = 0; //sai do loop de captura
						continue;
					}else if(x < 0){
						opcao = -1; //encerra inserção
						continue;
					}else{
						System.out.println("A leitura deve estar entre 0 e 9999.");
						continue;
					}
				}
			}
			if(x < 0 ){
				System.out.print("Encerrada... ");
				pegaEnter();
				break;
			}
			if(classe == "a"){
				System.out.println("Consumo normal: " + x + "\tConsumo em horário de pico: " + x2);
				valoresLeiturasP.add(x2);
			}else if(classe == "b"){
				System.out.println("Consumo normal: " + x);
			}
			valoresLeiturasN.add(x);
			datasLeituras.add(string2date("01/" + mesAnt));
			meses++;
		}
		opcao = 0;
	}
	private static Date dtSubt(Date date, int dias, int meses, int anos) { //subtrai meses de um Date
		String dtStr = date2string(date);
		String[] dtArr = dtStr.split("/");
		int dia = Integer.parseInt(dtArr[0]);
		int mes = Integer.parseInt(dtArr[1]);
		int ano = Integer.parseInt(dtArr[2]);
		//System.out.print(dia + "/" + mes + "/" + ano+" - "+meses+"\t\t");
		int anosAMenos = meses/12;
		int anoFinal = ano - anosAMenos;
		int mesesRestantes = Math.abs((anosAMenos*12) - meses);
		int mesFaltante = mes - mesesRestantes;
		int mesFinal = mes;
		if(mesFaltante < 1){
			mesFinal = 12 - Math.abs(mes - mesesRestantes);
			anoFinal--;
		}else if(mesFaltante == 0){
			mesFinal = 12;
			anoFinal--;
		}else{
			mesFinal = mesFaltante;
		}
		return string2date(dia+"/"+mesFinal+"/"+anoFinal);		
	}
	public static String date2string(Date dt){ // converte Date para String
		SimpleDateFormat dtMasc = new SimpleDateFormat("dd/MM/yyyy");
		String dtStr;
		try {
			dtStr = dtMasc.format(dt); //gera string da data com a mascara
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return dtStr;
	}
	public static Date string2date(String dt){ // converte String para Date
		SimpleDateFormat dtMasc = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try{
			date = dtMasc.parse(dt); 
		}catch(ParseException e){
			e.printStackTrace();
			return null;
		}
		return date;
	}
	private static Integer calcDifKw(Integer atual, Integer anterior) { // calcula diferença de leituras
		Integer usoKw = 0;
		if(atual < anterior){
			usoKw = Math.abs(anterior - 10000) + atual;
		}else{
			usoKw = atual - anterior;
		}
		return usoKw;
	}
	private static void pegaEnter() {
		System.out.println("Pressione enter para continuar...");
		leitor.nextLine();
	}
	/*
	private static void insA() {
		System.out.println("Inserindo ClasseA...");
		int cod = codigoA;
	ClasseA cA = new ClasseA(cod, "Állan Lima da Cunha", "Rua", "Benedito leite", "420a", "Jd Sta Izabel", "Hortolândia", "SP");
		classeA.add(cA);
		codigoA++;
		ArrayList<Integer> n = new ArrayList<Integer>();
		//for (int j = 5; j > 0; j--) {
		for (int j = 0; j < 5; j++) {
			n.add(j*175);
		}
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int j = 0; j < 5; j++) {
			p.add(j*95);
		}
		ArrayList<Date> d = new ArrayList<Date>();
		Date mesAnt;
		int meses = 0;
		Date data = new Date();
		for (int j = 0; j < 5; j++) {
			mesAnt = dtSubt(data, 0, meses, 0);
			d.add(mesAnt);
			meses++;
		}
		cA.setLeiturasN(n);
		cA.setLeiturasP(p);
		cA.setDtLeituras(d);
	}
	private static void insB() { // classe de teste
		System.out.println("Inserindo ClasseB...");
		int cod = codigoB;
		ClasseB cB = new ClasseB(cod, "ALLAN LIMA DA CUNHA", "Rua", "Benedito leite", "420a", "Jd Sta Izabel", "Hortolândia", "SP");
		classeB.add(cB);
		codigoB++;
		ArrayList<Integer> n = new ArrayList<Integer>();
		//for (int j = 5; j > 0; j--) {
		for (int j = 0; j < 5; j++) {
			n.add(j*15);
		}
		ArrayList<Date> d = new ArrayList<Date>();
		Date mesAnt;
		int meses = 0;
		Date data = new Date();
		//for (int j = 5; j > 0; j--) {
		for (int j = 0; j < 5; j++) {
			mesAnt = dtSubt(data, 0, meses, 0);
			d.add(mesAnt);
			meses++;
		}
		cB.setLeiturasN(n);
		cB.setDtLeituras(d);
	}
	*/
}
