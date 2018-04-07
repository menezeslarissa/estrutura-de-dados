package testes.listas.circular.duplaencadeada.ed;

public class Lista {
	No inicio = null;
	No fim = null;
	No aux;
	
	public void inserirInicio(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) { //lista vazia
			inicio = no;
			fim = no;
			no.setAnt(inicio);
			no.setProx(inicio);
		} else { //lista ja tem elementos
			no.setProx(inicio);
			inicio.setAnt(no);
			no.setAnt(fim);
			fim.setProx(no);
			inicio = no;
		}
	}
	
	public void inserirFim(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) {
			inicio = no;
			fim = no;
			no.setProx(inicio);
			no.setAnt(inicio);
		} else {
			fim.setProx(no);
			no.setAnt(fim);
			fim = no;
			fim.setProx(inicio);
			inicio.setAnt(fim);
		}
	}
	
	public void mostrarInicio() {
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			aux = inicio;
			do {
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			}while(aux!=inicio);
		}
	}
	
	public void mostrarFim() {
		if(inicio == null) {
			System.out.println("Lista está vazia");
		} else {
			aux = fim;
			do {
				System.out.print(aux.getDado() + " ");
				aux = aux.getAnt();
			}while(aux!=fim);
		}
	}
	
	private boolean remover(int dado){
		int p = 0;
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			aux = inicio;
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
							inicio.setAnt(fim);
							fim.setProx(inicio);
							aux = inicio;
							p++;
						} else if(aux == fim) { // elemento está no fim da lista
							fim = fim.getAnt();
							fim.setProx(inicio);
							inicio.setAnt(fim);
							aux = null;
							p++;
						} else {
							//elemento está no meio da lista
							aux.getAnt().setProx(aux.getProx());
							aux.getProx().setAnt(aux.getAnt());
							aux = aux.getProx();
							p++;
						}
					}
				}else {
					aux = aux.getProx();
				}	
			}while(aux!=fim);
			if(p!=0) return true;
			else return false;
		}
		return false;
	}
	
	public void verificarRemover(int d) {
		if(remover(d)) {
			System.out.println("Elemento removido!");
		} else {
			System.out.println("Elemento não encontrado");
		}
	}
	
	public void esvaziar() {
		if(inicio == null) {
			System.out.println("Lista vazia!");
		} else {
			inicio = null;
			System.out.println("Lista esvaziada!");
		}
	}
}
