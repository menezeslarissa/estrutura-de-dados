package testes.listas.circular.duplaencadeada.ed;

public class Teste {
	public static void main(String[] args) {
		Lista lista = new Lista();
		
		System.out.println("Inserindo elementos no inicio da lista... ");
		lista.inserirInicio(5);
		lista.inserirInicio(4);
		lista.inserirInicio(4);
		lista.inserirInicio(3);
		lista.inserirInicio(1);
		
		System.out.println("Lista mostrada do inicio ao fim:");
		lista.mostrarInicio();
		System.out.println();
		System.out.println("Lista mostrada do fim ao inicio:");
		lista.mostrarFim();
		
		System.out.println("Esvaziando lista...");
		lista.esvaziar();
		
		System.out.println("Inserindo elementos no fim da lista... ");
		lista.inserirFim(5);
		lista.inserirFim(4);
		lista.inserirFim(4);
		lista.inserirFim(3);
		lista.inserirFim(1);
		System.out.println("Lista mostrada do inicio ao fim:");
		lista.mostrarInicio();
		System.out.println();
		System.out.println("Lista mostrada do fim ao inicio:");
		lista.mostrarFim();
		System.out.println();
		
		System.out.println("Removendo elemento 4: ");
		lista.verificarRemover(4);
		System.out.println("Lista mostrada do inicio ao fim:");
		lista.mostrarInicio();
		System.out.println();
		System.out.println("Lista mostrada do fim ao inicio:");
		lista.mostrarFim();
		System.out.println();
	}
}
