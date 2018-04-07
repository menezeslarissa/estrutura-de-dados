package testes.listas.duplamente.encadeada.ed;

public class Lista {
	No inicio = null;
	No fim = null;
	No aux;
	
	//elementos serão inseridos no começo da lista
	public void inserirInicio(int dado) {
		No no = new No();
		no.setDado(dado);
		
		if(inicio == null) { // lista está vazia
			inicio = no;
			fim = no;
			no.setAnt(null);
			no.setProx(null);
		} else { //lista n está vazia, elemento será inserido no incio da lista
			no.setProx(inicio);
			inicio.setAnt(no);
			no.setAnt(null);
			inicio = no;
		}
	}
	
	//elementos serão inseridos no fim da lista
	public void inserirFim(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) {
			inicio = no;
			fim = no;
			no.setAnt(null);
			no.setProx(null);
		} else { // lista n está vazia, elemento serão inseriods no fim dela
			fim.setProx(no);
			no.setAnt(fim);
			no.setProx(null);
			fim = no;
		}
	}
	
	//mostrar todos os elementos da lista do inicio ao fim
	public void mostrarInicio() {
		if(inicio == null){
			System.out.println("Lista está vazia");
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
			System.out.println("Lista está vazia!");
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
			System.out.println("Lista está vazia!");
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
						//elemento está no meio da lista
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
			System.out.println("Elemento não encontrado");
		}
	}
	
	public void esvaziarLista() {
		if(inicio == null) {
			System.out.println("Lista está vazia!");
		} else {
			inicio = null;
			System.out.println("Lista esvaziada!");
		}
	}
	
}
