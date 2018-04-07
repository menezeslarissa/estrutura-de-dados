package testes.pilhas.ed;

public class Pilha {
	No topo = null; // inserção e remoção acontecem no topo da pilha
	No aux;
	
	public void inserir(int dado) {
		No no = new No();
		no.setDado(dado);
		no.setProx(topo);
		topo = no;
	}
	
	public void mostrar() {
		if(topo == null) {
			System.out.println("Pilha está vazia!");
		} else {
			//pilha contém elementos e eles serão mostrados do último ao primeiro
			aux = topo;
			while(aux!=null) {
				System.out.println(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	public void remover() {
		if(topo == null) {
			System.out.println("Pilha está vazia!");
		} else {
			//o ultimo elemento inserido será removido
			topo = topo.getProx();
		}
	}
	
	public void esvaziar() {
		if(topo == null) {
			System.out.println("Pilha está vazia!");
		} else {
			topo = null;
			System.out.println("Pilha esvaziada!");
		}
	}
}
