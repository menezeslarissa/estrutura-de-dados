package testes.listas.duplaencadeada.ordenada.ed;

public class Lista {
	No inicio = null;
	No fim = null;
	No aux;
	
	public void inserir(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) { // lista vazia
			inicio = no;
			fim = no;
			no.setProx(null);
			no.setAnt(null);
		} else { // listá ja tem elementos
			//ordenação crescente
			aux = inicio;
			while(aux!=null && no.getDado()>aux.getDado()) aux = aux.getProx();
			if(aux == inicio) {
				//o novo numero a ser inserido eh menor que todos da lista
				//será inserido no inicio
				no.setProx(inicio);
				no.setAnt(null);
				inicio.setAnt(no);
				inicio = no;
			} else if(aux == null) {
				//o numero a ser inserido eh menor que todos
				//será inserido no fim
				fim.setProx(no);
				no.setAnt(fim);
				fim = no;
				fim.setProx(null);
			} else {
				//numero será inserido entre dois números
				no.setProx(aux);
				aux.getAnt().setProx(no);
				no.setAnt(aux.getAnt());
				aux.setAnt(no);
			}
		}
	}
	
	//mostrar elementos do inicio ao fim
	public void mostrar() {
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			aux = inicio;
			while(aux !=null) {
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	//remover elementos da lista
	private boolean remover(int dado) {
		int p = 0;
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			aux = inicio;
			while(aux!=null) {
				if(aux.getDado() == dado) {
					if(aux == inicio) { //elemento está no inicio da lista
						inicio = aux.getProx();
						if(inicio!=null) inicio.setAnt(null);
						aux = inicio;
					} else if(aux == fim) {
						//elemento está no fim da lista
						fim = fim.getAnt();
						fim.setProx(null);
						aux = null;
					} else {
						//elemento está no meio da lista
						aux.getAnt().setProx(aux.getProx());
						aux.getProx().setAnt(aux.getAnt());
						aux = aux.getProx();
					}
					p++;
				} else {
					aux = aux.getProx();
				}
			}
			if(p!=0) return true;
				else return false;
		}
		return false;
	}
	
	public void verificarRemover(int d) {
		if(remover(d)) {
			System.out.println("Elemento removido com sucesso!");
		} else {
			System.out.println("Elemento não encontrado!");
		}
	}
	
	//esvaziar a lista
	public void esvaziar() {
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			inicio = null;
		}
	}
}
