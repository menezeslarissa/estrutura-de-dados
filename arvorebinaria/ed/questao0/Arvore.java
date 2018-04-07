package questao0;

public class Arvore {
	NoArvore raiz; // refer�ncia para o n� raiz da mesma
	int tamanho; // tamanho da arvore
	int totalEstoque = 0; // quantidade em estoque de todos os produtos
							// adicionados
	double valorGeral = 0; // valor de todos os produtos

	public Arvore() {
		raiz = null; // raiz nula significa que n�o h� elementos
		tamanho = 0;
	}

	public int tamanho() {
		return tamanho; // 
	}

	public void insere(int chave, String nomeProduto, double valorProduto,
			int qtdEstoque) {
		if (raiz == null) { // caso n�o haja elementos
			raiz = new NoArvore(chave, null, nomeProduto, valorProduto,
					qtdEstoque); //seta novo n� como raiz
			tamanho = 1;
			this.valorGeral += (valorProduto * qtdEstoque);
			this.totalEstoque += qtdEstoque;
			return;
		}
		NoArvore noAtual = raiz;
		NoArvore noPai; // referencia para o pai do noAtual

		do {
			noPai = noAtual; //compara a chave a ser inserida com a chave do n� atual
			if (chave < noAtual.getChave())
				noAtual = noAtual.getEsquerda(); //subarvore a esquerda
			else if (chave > noAtual.getChave())
				noAtual = noAtual.getDireita(); //subarvore a direita
			else { // se a chave for igual, muda-se os valores do n� atual para o novo valor e retorna
				noAtual.setNomeProduto(nomeProduto);
				noAtual.setValorProduto(valorProduto);
				noAtual.setQtdEstoque(qtdEstoque);
				return;
			}
		} while (noAtual != null);
		//executa o la�o at� a subarvore ser nula, ou seja, chegou numa folha
		//novo n� � filho desse n� encontrado
		NoArvore noNovo = new NoArvore(chave, noPai, nomeProduto, valorProduto,
				qtdEstoque); //novo n� seta o pai como sendo o n� encontrado
		if (chave < noPai.getChave()) //subarvore que era nula aponta para novoN�
			noPai.setEsquerda(noNovo);
		else
			noPai.setDireita(noNovo);

		tamanho++; //aumenta o tamanho da �rvore

		this.valorGeral += (valorProduto * qtdEstoque);
		this.totalEstoque += qtdEstoque;
	}

	public NoArvore busca(int chave) {
		NoArvore noAtual = raiz;

		while (noAtual != null && noAtual.getChave() != chave) { //enquando n� atual for diferente de nulo
			if (chave < noAtual.getChave())                      // e a chave for diferente
				noAtual = noAtual.getEsquerda();
			else
				noAtual = noAtual.getDireita();
		}
		return noAtual; //para quando encontra
	}

	public double mostrarValorGeral() {
		return this.valorGeral;
	}

	public int mostrarTotalEstoque() {
		return this.totalEstoque;
	}

	public void mostraOrdem() {
		mostraOrdem(raiz); //ome�a pela raiz
	}						// esquerda e imprime
							//direita
	public void mostraOrdem(NoArvore subArvore) {
		if (subArvore != null) {
			// System.out.println();
			mostraOrdem(subArvore.getEsquerda());
			System.out.println("\nNome do produto: "
					+ subArvore.getNomeProduto() + "\nValor do produto: "
					+ subArvore.getValorProduto()
					+ " \nQuantidade em estoque: " + subArvore.getQtdEstoque()
					+ "\n[chave] C�digo do produto: " + subArvore.getChave());
			mostraOrdem(subArvore.getDireita());
			System.out.println();
		}
	}

	public NoArvore minimo() { // n� mais a esquerda
		return minimo(raiz);
	}

	public NoArvore minimo(NoArvore noAtual) { //enquanto a esquerda do atual for diferente de nulo
		while (noAtual != null && noAtual.getEsquerda() != null) //segue a subArvore a esquerda
			noAtual = noAtual.getEsquerda();
		return noAtual;
	}

	public NoArvore maximo() { // n� mais a direita
		return maximo(raiz); //se a direita do atual for diferente ne nulo, segue para a subarvore a direita
	}

	public NoArvore maximo(NoArvore noAtual) {
		while (noAtual != null && noAtual.getDireita() != null)
			noAtual = noAtual.getDireita();
		return noAtual;
	}

	public NoArvore predecessor(NoArvore no) { //n� com a maior chave menor que a chave de x
		if (no.getEsquerda() != null) // se tiver filho a esquerda
			return maximo(no.getEsquerda()); //retorna o m�ximo da subarvore a esquerda

		NoArvore noAtual = no.getPai(); // enquanto tiver pai e o n� estiver a esquerda do pai
		while (noAtual != null && no == noAtual.getEsquerda()) {
			no = noAtual;
			noAtual = noAtual.getPai();//sobe de n�vel
		}
		return noAtual;
	}

	public NoArvore sucessor(NoArvore no) { //n� com a menor chave maior que a de x
		if (no.getDireita() != null) // n� possui filho a direita
			return minimo(no.getDireita()); //retorna o minimo da subarvore a direita

		NoArvore noAtual = no.getPai(); //enquanto tiver pai e n� estiver a direita
		while (noAtual != null && no == noAtual.getDireita()) {
			no = noAtual; 
			noAtual = noAtual.getPai(); //sobre de n�vel
		}
		return noAtual;
	}

	public void remove(NoArvore noRemove) {
		tamanho--;
		NoArvore noPai = noRemove.getPai();
		if (noRemove.getEsquerda() == null && noRemove.getDireita() == null) { //se os dois filhos forem nulos, ent�o � uma folha
			if (noPai == null) raiz = null; // a raiz (sem filhos)
			else { 
				if (noRemove == noPai.getEsquerda()) noPai.setEsquerda(null);
				else noPai.setDireita(null);
			}
		} //n� que tem apenas um filho
		else if (noRemove.getEsquerda()==null || noRemove.getDireita()==null){ 
			NoArvore y = noRemove.getEsquerda() != null ? noRemove.getEsquerda() //se a esquerda for diferente de nulo, pega o n� da esquerda, sen�o
					: noRemove.getDireita(); 									// pega o da direita
			y.setPai(noPai); //seta o pai como o pai do n� que se deseja remover
			if (noPai == null) raiz = y; // mexendo com a raiz ; raiz recebe novo n�
			else { //meio da arvore
				if (noRemove == noPai.getEsquerda()) noPai.setEsquerda(y); // y vai ser o n� da esquerda
				else noPai.setDireita(y); //y vai ser o da direita
			}
		}
		else { //possui dois filhos
			NoArvore noSucessor = sucessor(noRemove); //remove seu sucessor (que ter� no m�x um filho)
			noRemove.setChave(noSucessor.getChave()); //substitui os dados do n� a ser removido
			noRemove.setNomeProduto(noSucessor.getNomeProduto()); //pelo seu sucessor que foi removido
			noRemove.setValorProduto(noSucessor.getValorProduto());
			noRemove.setQtdEstoque(noSucessor.getQtdEstoque());
			remove(noSucessor);
		}
	}
}
