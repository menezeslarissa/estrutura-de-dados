package questao03;

public class ItemNo {
	private String chave;
	private String valor;
	private ItemNo prox;
	
	public ItemNo() {
		
	}
		
	public ItemNo(String chave, String valor) {
		super();
		this.valor = valor;
		this.chave = chave;
		this.prox = null;
	}
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public ItemNo getProx() {
		return prox;
	}
	public void setProx(ItemNo prox) {
		this.prox = prox;
	}
	
	
}
