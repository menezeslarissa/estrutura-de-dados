package questao01;

public class Arvore {
	NoArvore raiz;
	int tamanho;
	
	public Arvore(){
		raiz = null;
		tamanho = 0;
	}
	
	public int tamanho(){
		return tamanho;
	}
	
	public void insere(int chave, Estudante aluno){ 
		if(raiz == null){
			raiz = new NoArvore(chave, aluno, null);
			tamanho = 1;
			return;
		}
		NoArvore noAtual = raiz;
		NoArvore noPai;
		
		do{
			noPai = noAtual;
			if(chave< noAtual.getChave()) noAtual = noAtual.getEsquerda();
			else if(chave>noAtual.getChave()) noAtual = noAtual.getDireita();
				else{
					noAtual.setAluno(aluno);
					return;
				}
		}while(noAtual != null);
		
		NoArvore noNovo = new NoArvore(chave, aluno, noPai);
		if(chave < noPai.getChave()) noPai.setEsquerda(noNovo);
		else
			noPai.setDireita(noNovo);
		
		tamanho++;
	}
	
	public NoArvore busca(int chave){ 
		NoArvore noAtual = raiz;
		
		while(noAtual != null && noAtual.getChave() != chave){
			if(chave < noAtual.getChave())
				noAtual = noAtual.getEsquerda();
			else
				noAtual = noAtual.getDireita();
		}
		return noAtual;
	}
	
	public void mostraPreOrdem(){
		mostraPreOrdem(raiz);
	}
	
	public void mostraPreOrdem(NoArvore subArvore){
		if(subArvore != null){
			System.out.println();
			System.out.println("Chave do aluno: " + subArvore.getChave() +
					"\nMatrícula do aluno: "+ subArvore.getAluno().getMatricula() +
					" \nNome do aluno: " + subArvore.getAluno().getNome() +
					"\nPosição no vestibular: " + subArvore.getAluno().getPos());
			mostraPreOrdem(subArvore.getEsquerda());
			mostraPreOrdem(subArvore.getDireita());
			System.out.println();
		}
	}
	
	public void mostraPosOrdem(){
		mostraPosOrdem(raiz);
	}
	
	public void mostraPosOrdem(NoArvore subArvore){
		if(subArvore != null){
			mostraPosOrdem(subArvore.getEsquerda());
			mostraPosOrdem(subArvore.getDireita());
			System.out.println("Chave do aluno: " + subArvore.getChave() +
					"\nMatrícula do aluno: "+ subArvore.getAluno().getMatricula() +
					" \nNome do aluno: " + subArvore.getAluno().getNome() +
					"\nPosição no vestibular: " + subArvore.getAluno().getPos());
			System.out.println();
		}
	}
	
	public void mostraOrdem(){
		mostraOrdem(raiz);
	}
	
	public void mostraOrdem(NoArvore subArvore){
		if(subArvore != null){
			//System.out.println();
			mostraOrdem(subArvore.getEsquerda());
			System.out.println("\nChave do aluno: " + subArvore.getChave() +
					"\nMatrícula do aluno: "+ subArvore.getAluno().getMatricula() +
					" \nNome do aluno: " + subArvore.getAluno().getNome() +
					"\nPosição no vestibular: " + subArvore.getAluno().getPos());
			mostraOrdem(subArvore.getDireita());
			System.out.println();
		}
	}
}
