package aquecimento;

import java.util.ArrayList;

public class Agenda {
	ArrayList<Pessoa> contatos = new ArrayList<Pessoa>();
	void armazenaPessoa(String nome, int idade, float altura){
		Pessoa p = new Pessoa(nome,idade,altura);
		contatos.add(p);
/*		p.setNome(nome);
		p.setIdade(idade);
		p.setAltura(altura);*/
	}
	void removePessoa(String nome){
		for (int i = 0; i < contatos.size(); i++) {
			if(contatos.get(i).getNome().toLowerCase().contains(nome.toLowerCase())){
				contatos.remove(i);
			}
		}
	}
	void buscaPessoa(String nome){
		for (int i = 0; i < contatos.size(); i++) {
			if(contatos.get(i).getNome().toLowerCase() == nome.toLowerCase()){
				System.out.println(contatos.get(i).getNome() + " foi encontrado na posição " + i + ".");
			}
		}
	}
	void imprimeAgenda(){
		for (int i = 0; i < contatos.size(); i++) {
			System.out.println(contatos.get(i).getNome() + " " + contatos.get(i).getIdade() + " anos " + contatos.get(i).getIdade() + "m.");
		}
	}
	void imprimePessoa(int index){
		try{
			contatos.get(index);
		}catch(NullPointerException e){
			System.out.println("Valor inválido.");
			return;
		}
		System.out.println(contatos.get(index).getNome() + " " + contatos.get(index).getIdade() + " anos " + contatos.get(index).getIdade() + "m.");
	}

}
