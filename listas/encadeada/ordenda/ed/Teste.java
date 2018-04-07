package testes.listas.encadeada.ordenda.ed;

public class Teste {

	public static void main(String[] args) {
		Lista lista = new Lista();
		
		lista.inserir(5);
		lista.inserir(9);
		lista.inserir(7);
		lista.inserir(1);
		lista.inserir(3);
		
		lista.mostrar();
		
		lista.verificarRemover(9);

		lista.mostrar();

	}

}
