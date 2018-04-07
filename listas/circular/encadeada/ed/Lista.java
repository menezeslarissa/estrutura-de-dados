package testes.listas.circular.encadeada.ed;

public class Lista {
	No inicio = null;
	No fim = null;
	No aux;
	No ant;
	
	public void inserirInicio(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) { // lista vazia
			inicio = no;
			fim = no;
			fim.setProx(inicio);
		} else { // lista ja tem elementos
			no.setProx(inicio);
			inicio = no;
			fim.setProx(inicio); //fim apontando p inicio
		}
	}
	
	public void inserirFim(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) { // lista está vazia
			inicio = no;
			fim = no;
			fim.setProx(inicio);
		} else { // lista tem elementos
			fim.setProx(no);
			fim = no;
			fim.setProx(inicio);	
		}
	}
	//mostrar todos os elementos
	public void mostrar() {
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			aux = inicio;
			do {
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			} while(aux!=inicio);
		}
	}
	
	//remover elementos
	private boolean remover(int dado) {
		int p = 0;
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			aux = inicio;
			ant = null;
			do {
				if(aux.getDado() == dado) {
					//se a lista tiver apenas um elemento
					if(inicio == fim) {
						inicio = null;
						p++;
					}
					else {
							//elemento é o primeiro da lista
							if(aux == inicio) {
								inicio = aux.getProx();
								fim.setProx(inicio);
								aux = inicio;
								p++;
							} else if(aux == fim) { // elemento está no fim da lista
								fim= ant;
								fim.setProx(inicio);
								aux = aux.getProx();
								p++;
							} else {
								//elemento está no meio da lista
								ant.setProx(aux.getProx());
								aux = aux.getProx();
								p++;
							}
					}
				}else {
					ant = aux;
					aux = aux.getProx();
				}	
			}while(aux!=inicio);
			if(p!=0) return true;
				else return false;
		}
		return false;
	}
	
	public void verificarRemover(int d) {
		if(remover(d)) {
			System.out.println("Elemento foi removido!");
		} else {
			System.out.println("Elemento não encontrado!");
		}
	}
	
	public void esvaziar() {
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			inicio = null;
			System.out.println("Lista esvaziada!");
		}
	}
}
