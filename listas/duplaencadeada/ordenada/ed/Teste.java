package testes.listas.duplaencadeada.ordenada.ed;

public class Teste {
	public static void main(String args[]) {
		Lista lista = new Lista();
		
		lista.inserir(5);
		lista.inserir(4);
		lista.inserir(4);
		lista.inserir(3);
		lista.inserir(1);
		
		lista.mostrar();
		
		lista.verificarRemover(4);
		lista.mostrar();
		
		lista.esvaziar();
	
		lista.mostrar();
		
	}
}
