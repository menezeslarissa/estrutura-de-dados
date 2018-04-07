package testes.listas.duplamente.encadeada.ed;

public class Teste {
	public static void main(String args[]) {
		Lista lista = new Lista();
		//inserindo no fim
		lista.inserirFim(5);
		lista.inserirFim(4);
		lista.inserirFim(1);
		lista.inserirFim(2);
		lista.inserirFim(3);
		lista.inserirFim(7);
		System.out.println("Mostrando do fim ao inicio: ");
		lista.mostrarFim();
		System.out.println("\nMostrando do inicio ao fim: ");
		lista.mostrarInicio();
		System.out.println("\n\n");
		
		
		//esvaziando a lista
		lista.esvaziarLista();
		//inserindo no inicio
		lista.inserirInicio(5);
		lista.inserirInicio(4);
		lista.inserirInicio(3);
		lista.inserirInicio(2);
		lista.inserirInicio(1);
		System.out.println("Mostrando do fim ao inicio: ");
		lista.mostrarFim();
		System.out.println("\nMostrando do inicio ao fim: ");
		lista.mostrarInicio();
		
	}
}
