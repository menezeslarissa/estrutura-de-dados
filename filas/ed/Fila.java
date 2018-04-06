package testes.filas.ed;

public class Fila {
	No inicio = null; //remoção acontece no inicio
	No fim = null;  //inserção acontece no fim
	No aux;


	public void inserir(int dado) {
		No no = new No();
		no.setDado(dado);
		no.setProx(null);
		if(inicio == null) { // fila está vazia
			inicio = no;
			fim = no;
		} else {
			fim.setProx(no);
			fim = no;
		}
	}

	public void mostrar() {
		if(inicio == null) {
			System.out.println("Fila esta vazia!");
		} else {
			aux = inicio;
			while(aux!=null){
				System.out.print(aux.getDado() + " ");
				aux = aux.getProx();
			}
		}
	}
	
	public void remover(){
		if(inicio == null){
			System.out.println("Fila está vazia");
		} else{
			inicio = inicio.getProx();
		}
	}
	
	public void esvaziar(){
		if(inicio==null){
			System.out.println("Fila está vazia!");
		} else {
			inicio = null;
			System.out.println("Fila esvaziada!");
		}
	}
}
