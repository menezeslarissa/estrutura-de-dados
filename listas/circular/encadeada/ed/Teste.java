package testes.listas.circular.encadeada.ed;

public class Teste {

	public static void main(String[] args) {
		Lista lista = new Lista();
		
		System.out.println("Inserindo elementos no inicio da lista... ");
		lista.inserirInicio(5);
		lista.inserirInicio(4);
		lista.inserirInicio(4);
		lista.inserirInicio(3);
		lista.inserirInicio(1);
		
		System.out.println("Lista:");
		lista.mostrar();
		System.out.println();
		lista.verificarRemover(4);
		lista.mostrar();
		System.out.println("Esvaziando a lista...");
		lista.esvaziar();
		System.out.println();
		lista.mostrar();
		
		System.out.println("Inserindo elementos no fim da lista... ");
		lista.inserirFim(5);
		lista.inserirFim(4);
		lista.inserirFim(4);
		lista.inserirFim(3);
		lista.inserirFim(1);
		System.out.println("Lista:");
		lista.mostrar();
		
	}

}
