package testes.pilhas.ed;

public class Teste {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		pilha.inserir(5);
		pilha.inserir(4);
		pilha.inserir(3);
		pilha.inserir(2);
		pilha.inserir(1);
		
		pilha.mostrar();
		
		pilha.remover();
		System.out.println();
		pilha.mostrar();
		

	}

}
