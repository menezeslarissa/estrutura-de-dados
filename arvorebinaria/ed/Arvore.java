package testes.arvorebinaria.ed;

public class Arvore {
	No raiz = null; //arvore vazia entao raiz é null
	No aux;
	No aux1;
	No novo;
	No ant;
	NoP topo; //representa o topo da pilha
	NoP auxPilha;
	
	public void inserir(int dado){
		novo = new No();
		novo.setDado(dado);
		novo.setDireita(null);
		novo.setEsquerda(null);
		
		if(raiz==null){ // arvore vazia
			raiz = novo;
		} else {
			aux=raiz;
			int cont = 0;
			while(cont == 0){
				if(novo.getDado()<aux.getDado()){
					if(aux.getEsquerda() == null){
						aux.setEsquerda(novo);
						cont++;
					} else
						aux = aux.getEsquerda();
				} else if(novo.getDado() >= aux.getDado()){
					if(aux.getDireita() == null){
						aux.setDireita(novo);
						cont++;
					} else
						aux = aux.getDireita();
				}
			}
		}
	}
	
	public void consultarNo(int dado){
		if(raiz == null){ //arvoré está vazia
			System.out.println("Arvoré está vazia!");
		} else {
			aux = raiz;
			int cont = 0;
			while(aux!=null && cont == 0){
				if(aux.getDado() == dado){
					System.out.println("Número " + aux.getDado() + " encontrado na arvoré!");
					cont++;
				} else if(dado < aux.getDado()) 
							aux = aux.getEsquerda();
						else
							aux = aux.getDireita();			
			}
			if(cont == 0){
				System.out.println("Número não encontrado na árvore!");
			}
		}
	}
	
	//mostrar elementos da arvore em ordem
	public void mostrarOrdem(){
		if(raiz == null){
			System.out.println("Árvore está vazia.");
		} else { // elementos serão mostrados em ordem
			aux = raiz;
			//pilha está vazia
			topo = null;
			do{
				//caminha pela arvore pelo ramo da esquerda até null, colocando cada elemento numa pilha
				while(aux!=null){
					auxPilha = new NoP();
					auxPilha.setDado(aux);
					auxPilha.setProx(topo);
					topo = auxPilha;
					aux = aux.getEsquerda();
				}
				
				if(topo!=null){
					auxPilha = topo;
					System.out.println(auxPilha.getDado().getDado() + " ");
					aux = topo.getDado().getEsquerda();
					topo = topo.getProx();
				}
			}while(topo!=null || aux!=null);
		}
	}
	
	//mostrar elementos da arvore em pré-ordem
	public void mostrarPreOrdem(){
		if(raiz == null){
			System.out.println("Arvoré está vazia!");
		} else {
			aux = raiz;
			topo = null; // pilha vazia
			do{
				//caminha pela arvoré e coloca os elementos na pilha
				while(aux!=null){
					auxPilha = new NoP();
					System.out.println(aux.getDado()+" ");
					auxPilha.setDado(aux);
					auxPilha.setProx(topo);
					topo = auxPilha;
					aux = aux.getEsquerda();
				}
				if(topo!=null){
					auxPilha = topo;
					topo = topo.getProx();
					aux = auxPilha.getDado().getDireita();
				}
			} while(topo!=null || aux!=null);
		}
	}
	
	//mostrar elementos da arvore em pós-ordem
	public void mostrarPosOrdem(){
		if(raiz == null){
			System.out.println("Árvore está vazia");
		} else {
			aux = raiz;
			topo = null; // pilha está vazia
			do{
				//caminha na árvore pelo ramo da esquerda até null
				//colocando cada elemento numa pilha
				//antes de colocar a raiz de cada sub-arvore na pilha
				//caminha tbm pelo ramo da direita
				do{
					while(aux!=null){
						auxPilha = new NoP();
						auxPilha.setDado(aux);
						auxPilha.setProx(topo);
						topo = auxPilha;
						aux = aux.getEsquerda();
					}
					if(topo.getDado().getDireita() != null) aux = topo.getDado().getEsquerda();
				}while(aux!=null);
				
				if(topo!=null){
					System.out.println(topo.getDado().getDado() + " ");
					if(topo.getProx() != null){
						//existe mais de um elemento empilhado
						if(topo.getProx().getDado().getDireita() != null &&  topo.getProx().getDado().getDireita() != topo.getDado()){ 
							aux = topo.getProx().getDado().getDireita();
							topo = topo.getProx();
						} else{
							while(topo.getProx() != null && topo.getProx().getDado().getDireita() == topo.getDado()){
								topo = topo.getProx();
								System.out.println(topo.getDado().getDado() + " ");
							}
							topo = topo.getProx();
							if(topo != null) aux = topo.getDado().getDireita();
								else 
									aux = null;
						}
					} else{
						topo = topo.getProx();
						aux = null;
					}
				}
			}while(topo != null || aux!=null);
		}
	}
	
	//excluir um nó da arvore
	public void excluir(int dado){
		if(raiz == null){
			System.out.println("Árvore está vazia!");
		} else {
			aux = raiz;
			int cont = 0;
			while(cont == 0 && aux!=null){
				if(aux.getDado() == dado) cont = 1;
				else 
					if(aux.getDado()>dado) // o número está a esquerda da arvore
						aux = aux.getEsquerda();
					else // o número está a direta da arvoré
						aux = aux.getDireita();
			}
			
			if(cont == 0){
				System.out.println("Número não encontrado!");
			} else{
				if(aux != raiz){
					ant = raiz;
					while(ant.getDireita() != aux && ant.getEsquerda() != aux){
						if(ant.getDado() > dado) ant = ant.getEsquerda();
						else ant= ant.getDireita();
					}
					
					if(aux.getDireita() == null && aux.getEsquerda() == null){
						//um número folha será excluido
						if(ant.getDireita() == aux) ant.setDireita(null);
						else ant.setDireita(null);
					} else {
						//um número n folha será excluido
						if(aux.getDireita() != null && aux.getEsquerda() == null){
							//um numero que possui filhos apenas para a direita
							if(ant.getEsquerda() == aux) ant.setEsquerda(aux.getDireita());
							else ant.setDireita(aux.getDireita());
						} else if(aux.getEsquerda() != null && aux.getDireita() == null){
							//numero q possui filhos apenas para a esquerda
							if(ant.getEsquerda() == aux) ant.setEsquerda(aux.getEsquerda());
							else ant.setDireita(aux.getEsquerda());
						} else if(aux.getEsquerda() != null && aux.getDireita() != null){
							//numero q possui filhos p esq e dir
							if(ant.getDireita() == aux){
								ant.setDireita(aux.getDireita());
								aux1 = aux.getEsquerda();
							} else{
								ant.setEsquerda(aux.getEsquerda());
								aux1 = aux.getDireita();
							}
							//recolocando o pedaço da árvore
							aux = ant;
							while(aux!=null){
								if(aux.getDado() < aux1.getDado()){
									if(aux.getDireita() == null){
										aux.setDireita(aux1);
										aux = null;
									} else
										aux = aux.getDireita();
								} else if(aux.getDado() > aux1.getDado()){
									if(aux.getEsquerda() == null){
										aux.setEsquerda(aux1);
										aux = null;
									} else
										aux = aux.getEsquerda();
								}
							}
						}
					}
					
				} else{
					// o número a ser removido é a raiz
					if(aux.getDireita() == null && aux.getEsquerda() == null){
						//raiz n tem filhos e será excluida
						raiz = null;
					}else{
						if(aux.getDireita() != null && aux.getEsquerda() == null){
							//raiz será excluida e possuii filhos apenas p direita
							raiz = aux.getDireita();
						} else if(aux.getEsquerda() != null && aux.getDireita() == null){
							//raiz possui filhos apenas para a esquerda
							raiz = aux.getEsquerda();
						} else if(aux.getEsquerda() != null && aux.getDireita() != null){
							//raiz possui filhos para a esquerda e direita
							raiz = aux.getDireita();
							aux1 = aux.getEsquerda();
							aux = raiz;
							while(aux!=null){
								if(aux.getDado()<aux1.getDado()){
									if(aux.getDireita() == null){
										aux.setDireita(aux1);
										aux = null;
									} else
										aux = aux.getDireita();
								}else if(aux.getDado()>aux1.getDado()){
									if(aux.getEsquerda() == null){
										aux.setEsquerda(aux1);
										aux = null;
									} else
										aux = aux.getEsquerda();
								}
							}
						}
					}
				}
			}
		}
	}

}
