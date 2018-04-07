package questao0;

public class NoArvore {
	private int chave; // chave como sendo o código do produto
	private NoArvore esquerda;
	private NoArvore direita;
	private NoArvore pai;
	// atributos do produto
	private String nomeProduto;
	private double valorProduto; // valor de um determinado produt0
	private int qtdEstoque; // quantidadde em estoque de um determinado produto

	public NoArvore(int chave, NoArvore pai, String nomeProduto,
			double valorProduto, int qtdEstoque) {
		super();
		this.chave = chave;
		this.pai = pai;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.qtdEstoque = qtdEstoque;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
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
