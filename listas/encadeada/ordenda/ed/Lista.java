package testes.listas.encadeada.ordenda.ed;

public class Lista {
	No inicio = null;
	No fim = null;
	No aux;
	No anterior;
	
	public void inserir(int dado) {
		No no = new No();
		no.setDado(dado);
		if(inicio == null) {
			inicio = no;
			fim = no;
			no.setProx(null);
		} else { //elemento será inserido numa ordenação crescente 
			anterior = null;
			aux = inicio;
			while(aux!=null && no.getDado()>aux.getDado()) {
				anterior = aux;
				aux = aux.getProx();
			}
			//o elemento é o menor de todos
			if(anterior == null) {
				no.setProx(inicio);
				inicio = no;
			} else if(aux==null) {
				//o elemento é maior que todos
				fim.setProx(no);
				fim = no;
				fim.setProx(null);
			} else { // elemento será inserido entre dois números
				anterior.setProx(no);
				no.setProx(aux);
			}
		}
	}
	
	
	//mostrar lista
	public void mostrar() {
		if(inicio == null) {
			System.out.println("Lista vazia!");
		} else {
			aux = inicio;
			while(aux!=null) {
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	//remover elementos da lista
	private boolean remover(int dado) {
		if(inicio == null) {
			System.out.println("Lista vazia!");
		} else {
			aux = inicio;
			anterior = null;
			
			while(aux!=null) {
				if(aux.getDado() == dado) { // elemento encontrado
					if(aux == inicio) { //elemento está no inicio da lista
						inicio = aux.getProx();
						aux = inicio;
					} else if(aux == fim) { //elemento está no fim da lista 
						anterior.setProx(null);
						fim = anterior;
						aux = null;
					} else {
						anterior.setProx(aux.getProx());
						aux = aux.getProx();
					}
				
					return true;
				} else {
					anterior = aux;
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
			System.out.println("Elemento não existe!");
		}
	}
}
