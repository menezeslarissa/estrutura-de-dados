package testes.pilhas.ed;

public class Pilha {
	No topo = null; // inser��o e remo��o acontecem no topo da pilha
	No aux;
	
	public void inserir(int dado) {
		No no = new No();
		no.setDado(dado);
		no.setProx(topo);
		topo = no;
	}
	
	public void mostrar() {
		if(topo == null) {
			System.out.println("Pilha est� vazia!");
		} else {
			//pilha cont�m elementos e eles ser�o mostrados do �ltimo ao primeiro
			aux = topo;
			while(aux!=null) {
				System.out.println(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	public void remover() {
		if(topo == null) {
			System.out.println("Pilha est� vazia!");
		} else {
			//o ultimo elemento inserido ser� removido
			topo = topo.getProx();
		}
	}
	
	public void esvaziar() {
		if(topo == null) {
			System.out.println("Pilha est� vazia!");
		} else {
			topo = null;
			System.out.println("Pilha esvaziada!");
		}
	}
}
