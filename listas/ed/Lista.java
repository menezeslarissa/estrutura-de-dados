package testes.listas.ed;

public class Lista {
	No inicio = null; // lista vazia
	No fim = null;
	No aux;
	No anterior;
	
	//insere no inicio da lista
	public void adicionar(int dado) {
		No no = new No();
		no.setDado(dado);
		
		if(inicio == null) { // lista vazia então o elemento inserido será o primeiro e o último
			inicio = no;
			fim = no;
			no.setProx(null);
		} else { // lista já tem elementos
			no.setProx(inicio);
			inicio = no; // o novo elemento será inserido no inicio da lista
		}
	}
	
	//insere no final da lista
	public void adicionarFim(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) { // lista vazia
			inicio = no;
			fim = no;
			no.setProx(null);
		} else { // lista com elementos
			fim.setProx(no);
			fim = no;
			fim.setProx(null);
		}
	}
	
	//mostrar lista
	public void mostrar() {
		if(inicio == null){
			System.out.println("Lista está vazia!");
		} else { // lista contém elementos
			aux = inicio;
			while(aux!=null) {
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	//remover da lista o elemento inserido
	private boolean remover(int dado) {
		if(inicio == null) {
			System.out.println("Lista vazia!");
		} else {
			aux = inicio;
			anterior = null;
			while(aux!=null) {
				if(aux.getDado() == dado) { // elemento encontrado
					//elemento a ser removido é o primeiro da lista
					if(aux == inicio) {
						inicio = aux.getProx();
						aux = inicio;
					} else
						//elemento a ser removido é o último da lista
						if(aux == fim) {
							anterior.setProx(null);
							fim = anterior;
							aux = null;
						} else { // elemento está no meio da lista
							anterior.setProx(aux.getProx());
							aux = aux.getProx();
						}
					return true;
				} else {
					anterior = aux;
					aux = aux.getProx();
				}
			}
		}
		return false;
	}
	
	public void verificaRemover(int d) {
		boolean remove = remover(d);
		if(remove) {
			System.out.println("Elemento removido!");
		} else {
			System.out.println("Elemento não existe na lista!");
		}
	}
}