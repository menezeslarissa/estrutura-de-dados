 package testes.filas.ed;

public class Teste {

	public static void main(String[] args) {
		Fila fila = new Fila();
		
		fila.inserir(5);
		fila.inserir(4);
		fila.inserir(3);
		fila.mostrar();
		fila.remover();
		System.out.println();
		fila.mostrar();
	}

}
