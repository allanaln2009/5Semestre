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
		
		classeA = new ArrayList<ClasseA>(); //	lista de clientes de Alta tens�o
		classeB = new ArrayList<ClasseB>();//	lista de clientes de Baixa tens�o
		codigoA = 0;					  //	c�digo inicial para inser��o de clientes de classe A
		codigoB = 0; 					 //		c�digo inicial para inser��o de clientes de classe B
		leitor = new Scanner(System.in);//		leitor de entradas do usu�rio
		opcao = 0;					   //		vari�vel para lidar com sa�da de loop e entradas do usu�rio
		/*//for�a inser��o de clientes (para teste) fun��o ao final do c�digo
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
			System.out.println("Escolha uma op��o:");
			System.out.println("1 - Unidade Consumidora");
			System.out.println("2 - Definir custo energ�tico");
			System.out.println("3 - Sair");
			try{
				opcao = leitor.nextInt();
			}catch(InputMismatchException e){
				leitor.nextLine();
				System.out.println("Insira uma op��o v�lida.");
				continue;
			}
			leitor.nextLine();
			if(opcao == 1){
				menuUC();
			}else if(opcao == 2){
				System.out.println("CUSTO KW/h");
				System.out.println("O custo atual � de R$ " + taxa + " por KW/h, para alterar o valor, " +
				"defina a nova tarifa." +
				"\nOu insira um valor negativo para voltar ao menu anterior sem efetuar altera��es:"
				);
				float _taxa = 0;
				try{
					_taxa = leitor.nextFloat();
				}catch(InputMismatchException e){
					leitor.nextLine();
					System.out.println("Voc� n�o inseriu uma informa��o v�lida.");
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
			System.out.println("Escolha uma op��o:");
			System.out.println("1 - Cadastrar UC");
			System.out.println("2 - Cadastrar leituras");
			System.out.println("3 - Gerar faturas");
			System.out.println("4 - Voltar");
			try{
				opcao = leitor.nextInt();
			}catch(InputMismatchException e){
				leitor.nextLine();
				System.out.println("Insira uma op��o v�lida.");
				continue;
			}
			leitor.nextLine();
			if(opcao == 1){
				telaCadUC("cadastro de unidades");
				cadastroUC(classe);
			}else if(opcao == 2){
				if(classeA.size() == 0 && classeB.size() == 0){
					System.out.println("N�o h� nenhum cadastro para preencher. Por favor, cadastre unidades antes de continuar.");
					pegaEnter();
				}else{
					telaCadUC("cadastro de leituras");
					cadastroLeitura(classe);
				}
			}else if(opcao == 3){
				if(classeA.size() == 0 && classeB.size() == 0){
					System.out.println("N�o h� nenhum cadastro para preencher. Por favor, cadastre unidades e atribua leituras antes de continuar.");
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
	private static void telaCadUC(String titulo) { //desenha tela para cadastro de UCs, leituras e cria��o de faturas
		opcao = 0;
		while(opcao != 1 && opcao != 2 && opcao != 3){
			System.out.println(titulo.toUpperCase());
			System.out.println("Escolha uma op��o:");
			System.out.println("1 - UC Classe A");
			System.out.println("2 - UC Classe B");
			System.out.println("3 - Voltar");
			try{
				opcao = leitor.nextInt();
			}catch(InputMismatchException e){
				leitor.nextLine();
				System.out.println("Insira uma op��o v�lida.");
				continue;
			}
			leitor.nextLine();
			classe = opcao;
		}
		opcao = 0;
	}
	private static void cadastroUC(int classe) { // coleta informa��es para cadastro de cliente
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
		
		System.out.print("Digite o nome do propriet�rio: ");
		while (nome.isEmpty()) {
			nome = leitor.nextLine();//.replaceAll("[^a-zA-z]", "");
		}
		/*System.out.print("Digite o nome do propriet�rio: ");
		while (logra.isEmpty()) {
			nome = leitor.nextLine().replaceAll("[^a-zA-z]", "");
		}*/
		System.out.print("Digite apenas o endere�o: ");
		while (end.isEmpty()) {
			end = leitor.nextLine();
		}
		System.out.print("N�mero e letra: ");
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
		System.out.println("Unidade inserida!\nC�digo de unidade: " + (cod + 1));
		pegaEnter();
	}
	private static void cadastroLeitura(int classe) {
	// chama fun��o respons�vel pela captura das informa��es, mas antes verifica se dados foram preenchidos 
		if(classe == 1){ // classe alta
			if(classeA.size() == 0){
				System.out.println("N�o h� UC's de Classe A.");
				pegaEnter();
				return;
			}
			int codigo = exibeInfo("a", "c"); // parametros para "classeA" e "cadastro", retorna c�digo ou erro
			if(codigo == -2){ //c�digo inexistente
				return;
			}
			pegaValorMedidor("a");
			classeA.get(codigo).setLeiturasN(valoresLeiturasN);
			classeA.get(codigo).setLeiturasP(valoresLeiturasP);
			classeA.get(codigo).setDtLeituras(datasLeituras);
		}else if(classe == 2){ // classe baixa
			if(classeB.size() == 0){
				System.out.println("N�o h� UC's de Classe B.");
				pegaEnter();
				return;
			}
			int codigo = exibeInfo("b", "c"); // parametros para "classeB" e "cadastro"
			if(codigo == -2){ //c�digo inexistente
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
				System.out.println("N�o h� UC's de Classe A.");
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
				System.out.println("N�o h� UC's de Classe B.");
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
			System.out.println("Voc� ainda n�o cadastrou leituras para este cliente.");
			pegaEnter();
			return;
		}catch(java.lang.IndexOutOfBoundsException e){
			System.out.println("N�o h� leituras cadastradas para gerar uma fatura...");
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
		
		Integer atualP; // leitura mes atual - hor�rio de pico
		try{
			atualP = pico.get(tam);
		}catch(NullPointerException e){
			atualP = 0;
		}

		Integer anterP; // leitura mes anterior - hor�rio de pico
		try{
			anterP = pico.get(tam - 1);
		}catch(NullPointerException e){
			anterP = 0;
		}
		
		Date dataAtual = datas.get(tam); // mes fatura atual
		Date dataAnter = datas.get(tam - 1); // mes fatura anterior
		
		// calcula consumo energ�tico
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
			System.out.print("\tEm hor�rio de pico:               " + anterP
					+ " KW/h");
		}
		System.out.print("\n................................................."
				+ "\n................................................."
				+ "\nLeitura atual:" + "\n" + date2string(dataAtual)
				+ "\n\tMarcador normal:             " + atualN + " KW/h");
		if (v == 2) {
			System.out.print("\n\tMarcador hor�rio de pico:    " + atualP
					+ " KW/h");
		}
		System.out.print("\n\n\tConsumo em hor�rio normal:   " + usoKwN
				+ " KW/h" + "\n\t\t\t\t * R$ " + taxa + " = R$ " + custoN);
		if (v == 2) {
			System.out.print("\n\tConsumo em hor�rio de pico:  " + usoKwP
					+ " KW/h" + "\n\t\t\t\t * R$ " + taxaP + " = R$ " + custoP);
		}
		System.out.print("\n\tTotal:                     R$ " + valor
				+ "\n................................................."
				+ "\n.................................................\n");
	}
	private static int exibeInfo(String classe, String tipo){ //exibe informa��es de UC de acordo com seu c�digo
		int cod = 1;
		System.out.println("Digite o c�digo da UC Classe " + classe.toUpperCase() + ": ");
		try{
			cod = leitor.nextInt();
		}catch(InputMismatchException e){
			leitor.nextLine();
			System.out.println("Digite um c�digo v�lido.");
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
			System.out.println("Ops... Parece que esse c�digo ai n�o existe ainda.");
			pegaEnter();
			return -2;
		}
		if(classe == "a"){
			System.out.println("C�digo: " + (unidadeA.getCod()+1) + "\n" +
			"Propriet�rio: " + unidadeA.getNome() + "\n" +
			//"CEP: " + unidadeA.getCep() + "\n" +
			"Endere�o: " + unidadeA.getLogra() + " " + unidadeA.getEnd() + ", " + unidadeA.getNum() + "\n" +
			"\t  " + unidadeA.getBairro() + ", " + unidadeA.getCidade() + " - " + unidadeA.getUf() 
			);
		}else if(classe == "b"){
			System.out.println("C�digo: " + (unidadeB.getCod()+1) + "\n" +
			"Propriet�rio: " + unidadeB.getNome() + "\n" +
			//"CEP: " + unidadeB.getCep() + "\n" +
			"Endere�o: " + unidadeB.getLogra() + " " + unidadeB.getEnd() + ", " + unidadeB.getNum() + "\n" +
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
		System.out.println("Digite os valores correspondentes aos per�odos:\n Para finalizar a inser��o, basta inserir um valor negativo.");
		while(opcao >= 0){
			mesAnt = (date2string(dtSubt(dtAtual, 0, meses, 0))).substring(3,10); //pega mes e ano da data atual e subtrai com base em "meses"
			System.out.print(" " + mesAnt + " - ");
			opcao = 1;
			while(opcao == 1){
				leituras = leitor.nextLine();
				if(leituras.contains("-")){
					opcao = -1; //encerra inser��o
					x = -1;
					continue;
				}
				separadas = leituras.split(";");
				for (int i = 0; i < 2; i++) { // for�a retirada de letras
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
						System.out.print("Digite \"leitura normal;hor�rio de pico\" para refer�ncia " + mesAnt + ": ");
						continue;
					}else{
						System.out.print("Digite \"leitura normal\" para refer�ncia " + mesAnt + ": ");
						continue;
					}
				}
				try{
					x2 = Integer.parseInt(separadas[1]);
				}catch(ArrayIndexOutOfBoundsException e){
					if(classe == "a"){
						System.out.print("Digite \"leitura normal;hor�rio de pico\" para refer�ncia " + mesAnt + ": ");
						continue;
					}
				}catch(NumberFormatException e){
					if(classe == "a"){
						System.out.print("Digite \"leitura normal;hor�rio de pico\" para refer�ncia " + mesAnt + ": ");
						continue;
					}
				}

				if(classe == "a"){
					if((x2 >= 0 && x2 <= 9999) && (x >= 0 && x <= 9999)){
						opcao = 0; //sai do loop de captura
						continue;
						// n�o pode continuar aqui porque x tem de ser validado
					}else if(x2 < 0  || x < 0){
						opcao = -1; //encerra inser��o
						continue;
					}else{
						System.out.println("A leitura do hor�rio de pico deve estar entre 0 e 9999.");
						continue;
					}
				}else if(classe == "b"){
					if(x >= 0 && x <= 9999){
						opcao = 0; //sai do loop de captura
						continue;
					}else if(x < 0){
						opcao = -1; //encerra inser��o
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
				System.out.println("Consumo normal: " + x + "\tConsumo em hor�rio de pico: " + x2);
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
	private static Integer calcDifKw(Integer atual, Integer anterior) { // calcula diferen�a de leituras
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
	ClasseA cA = new ClasseA(cod, "�llan Lima da Cunha", "Rua", "Benedito leite", "420a", "Jd Sta Izabel", "Hortol�ndia", "SP");
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
		ClasseB cB = new ClasseB(cod, "ALLAN LIMA DA CUNHA", "Rua", "Benedito leite", "420a", "Jd Sta Izabel", "Hortol�ndia", "SP");
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
