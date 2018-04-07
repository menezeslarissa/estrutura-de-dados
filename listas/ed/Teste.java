package testes.listas.ed;

public class Teste {
	public static void main(String args[]) {
		Lista lista = new Lista();
		
		lista.adicionarFim(1);
		lista.adicionarFim(2);
		lista.adicionarFim(3);
		lista.adicionarFim(4);
		lista.adicionarFim(5);
		
		lista.mostrar();
		
		lista.verificaRemover(4);
		
		System.out.println();
		
		lista.mostrar();
		
		
	}
}
