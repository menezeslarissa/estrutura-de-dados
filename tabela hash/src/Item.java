
public class Item {
	private String chave; // chave do item; chave nula indica que o elemento foi removido
	private Object valor; // valor do item

	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	public Item(String item, Object valor) {
		super();
		this.chave = item;
		this.valor = valor;
	}
	
	
	
}
