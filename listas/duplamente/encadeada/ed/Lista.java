package testes.listas.duplamente.encadeada.ed;

public class Lista {
	No inicio = null;
	No fim = null;
	No aux;
	
	//elementos ser�o inseridos no come�o da lista
	public void inserirInicio(int dado) {
		No no = new No();
		no.setDado(dado);
		
		if(inicio == null) { // lista est� vazia
			inicio = no;
			fim = no;
			no.setAnt(null);
			no.setProx(null);
		} else { //lista n est� vazia, elemento ser� inserido no incio da lista
			no.setProx(inicio);
			inicio.setAnt(no);
			no.setAnt(null);
			inicio = no;
		}
	}
	
	//elementos ser�o inseridos no fim da lista
	public void inserirFim(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) {
			inicio = no;
			fim = no;
			no.setAnt(null);
			no.setProx(null);
		} else { // lista n est� vazia, elemento ser�o inseriods no fim dela
			fim.setProx(no);
			no.setAnt(fim);
			no.setProx(null);
			fim = no;
		}
	}
	
	//mostrar todos os elementos da lista do inicio ao fim
	public void mostrarInicio() {
		if(inicio == null){
			System.out.println("Lista est� vazia");
		} else {
			aux = inicio;
			while(aux != null) {
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	//mostrar elementos do fim ao inicio;
	public void mostrarFim() {
		if(inicio == null) {
			System.out.println("Lista est� vazia!");
		} else {
			aux = fim;
			while(aux!=null) {
				System.out.print(aux.getDado() + " ");
				aux = aux.getAnt();
			}
		}
	}
	
	private boolean remover(int dado) {
		if(inicio == null) {
			System.out.println("Lista est� vazia!");
		} else {
			aux = inicio;
			while(aux!=null) {
				if(aux.getDado() == dado) {
					if(aux == inicio) {
						//elemento encontrado no inicio da lista
						inicio = aux.getProx();
						if(inicio != null) inicio.setAnt(null);
						aux = inicio;
					} else if(aux == fim) {
						//elemento foi encontrado no fima da lista
						fim = fim.getAnt();
						fim.setProx(null);
						aux = null;
					} else {
						//elemento est� no meio da lista
						aux.getAnt().setProx(aux.getProx());
						aux.getProx().setAnt(aux.getAnt());
						aux = aux.getProx();
					}
				
					return true;
				}
				else {
					aux = aux.getProx();
				}
			}
			return false;
		}
		return false;
	}
	
	public void verificarRemover(int d) {
		if(remover(d)) {
			System.out.println("Elemento removido com sucesso!");
		} else {
			System.out.println("Elemento n�o encontrado");
		}
	}
	
	public void esvaziarLista() {
		if(inicio == null) {
			System.out.println("Lista est� vazia!");
		} else {
			inicio = null;
			System.out.println("Lista esvaziada!");
		}
	}
	
}
