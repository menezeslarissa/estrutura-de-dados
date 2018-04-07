package questao01;

public class NoArvore {
	private int chave; // a chave será a matricula do aluno no vestibular
	private Estudante aluno; // classe estudante tem nome e pos
	private NoArvore esquerda;
	private NoArvore direita;
	private NoArvore pai;
	
	public NoArvore(int chave, Estudante aluno, NoArvore pai) {
		super();
		this.chave = chave;
		this.aluno = aluno;
		this.pai = pai;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public Estudante getAluno() {
		return aluno;
	}

	public void setAluno(Estudante aluno) {
		this.aluno = aluno;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}

	public NoArvore getPai() {
		return pai;
	}

	public void setPai(NoArvore pai) {
		this.pai = pai;
	}
	
}
