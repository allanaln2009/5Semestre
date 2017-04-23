package aula5;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Principal {
	static int x = 0;
	static Scanner l = new Scanner(System.in);
	static String[] nome = new String[3];
	static String n = "";
	static ArrayList<Date> dt = new ArrayList<Date>();
	static ArrayList<Date> dt1 = new ArrayList<Date>();
	public static void main(String[] args) {
		ex2_4();
		//ex2_1();
		ex2_2();
		ex2_3();
		/*
		//ex4();ex4();ex4();ex4();ex4();
		while(x < 3){
			System.out.println("Digite o nome "+x+":");
			nome[x] = l.nextLine();
			System.out.println("Digite a data de nascimento:");
			n = l.nextLine();
			//dt[x] = string2date(n);
			dt.add(string2date(n));
			x++;
			//System.out.println(ATPS.Principal.date2string(dt[x]));
		}
		dt1 = (ArrayList<Date>) dt.clone();
		Collections.sort(dt1);
		for (int i = 0; i < dt1.size(); i++) {
			
			System.out.println(ATPS.Principal.date2string(dt1.get(i)));
		}
		*/
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
	public static void ex2(){
		System.out.println("Digite valor: ");
		float custoFab = 0;
		custoFab = l.nextFloat();
		float custoRev = custoFab * 1.28f;
		float imp = custoFab * 1.45f;
		System.out.println("Custo para consumidor: "+(custoFab+custoRev+imp));
	}
	public static void ex3(){
		ArrayList<Pessoa> pop = new ArrayList<Pessoa>();
		Pessoa p = null;
		Pessoa p2 = null;
		Pessoa temp = null;
		//pega idade maior
		for (int i = 0; i < pop.size(); i++) {
			try{
				p = pop.get(i);
			}catch(IndexOutOfBoundsException e){}
			try{
				p2 = pop.get(i+1);
			}catch(IndexOutOfBoundsException e){}
			
			if(temp == null){
				temp = p;		
			}
			
			if(p2.getIdade() > temp.getIdade()){
				temp = p2;
			}else if(p.getIdade() > temp.getIdade()){
				temp = p;
			}
		}
		
		int m = 0;
		int tam = pop.size() - 1;
		for (int i = 0; i < (pop.size()-1); i++) {
			p = pop.get(i);
			if(p.getSexo() == "f" && (p.getIdade() >= 18 && p.getIdade() <= 35) && p.getCorCabelo().toLowerCase() == "loiro" && p.getCorOlhos().toLowerCase() == "verde"){
				m++;
			}
		}
		float porc = (m * 100)/tam;
		System.out.println("Porcentagem de loirona novinha: "+porc+"%");
		/*
		tam 100
		m   x
		
		b=tam*x
		a=m*100
		t=a/b
		*/
	}
	public static void ex4(){
		float sm = 0;
		System.out.println("Digite saldo médio");
		sm = l.nextFloat();
		if(sm >= 0 && sm <= 200){
			System.out.println("Saldo médio: " + sm + ", sem direito.");
		}else if(sm >= 201 && sm <= 400){
			System.out.println("Saldo médio: " + sm + "+ " + (sm*0.2f) + ", 20% do valor");
		}else if(sm >= 401 && sm <= 600){
			System.out.println("Saldo médio: " + sm +  "+ " + (sm*0.3f) +  ", 30% do valor");
		}else if(sm >= 601){
			System.out.println("Saldo médio: " + sm +  "+ " + (sm*0.6f) + ", 60% do valor");
		}
	}
	public static void ex2_1(){
		int[] v = new int[2];
		for (int i = 0; i < 2; i++) {
			System.out.println("Digite o valor " + (i+1) + ":");
			v[i] = l.nextInt();
		}
		System.out.println("Maior:");
		if(v[0] > v[1]){
			System.out.println(v[0]);
		}else if(v[0] < v[1]){
			System.out.println(v[1]);
		}else{
			System.out.println("Não existe");
		}
	}
	public static void ex2_2(){ // por em classe
		Scanner scn = new Scanner(System.in); 
		int v = scn.nextInt();
		for (int i = v; i >= 0; i--) {
			System.out.println(i+ "; ");
		}
	}
	public static void ex2_3(){
		for (int i = 0; i < 30; i++) {
			if(i%2 != 0){
				System.out.print(i+"; ");
			}
		}
	}
	public static void ex2_4(){
		Scanner leitor = new Scanner(System.in);
		int[] v = new int[2];
		for (int i = 0; i < 2; i++) {
			System.out.println("Digite o valor " + (i+1) + ":");
			v[i] = leitor.nextInt();
		}
		System.out.println("Antes:");
		for (int i = 0; i < 2; i++) {
			System.out.println("V" + (i+1) + ": " + v[i]);
		}
		int a = v[0];
		v[0] = v[1];
		v[1] = a;
		System.out.println("\nDepois:");
		for (int i = 0; i < 2; i++) {
			System.out.println("V" + (i+1) + ": " + v[i]);
		}
	}
}
