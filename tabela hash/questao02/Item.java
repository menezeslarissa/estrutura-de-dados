package questao02;

public class Item {
	private String chave;
	private String valor;
	
	public Item() {
		
	}
	public Item(String chave, String valor) {
		super();
		this.chave = chave;
		this.valor= valor;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
