package questao02;

public class HashEndAberto {
	private Item[] tabela;
	private int tamanho;
	
	public HashEndAberto(int maxTam) {
		tabela = new Item[maxTam];
	}

	public int tamanho() {
		return tamanho;
	}

	public Item[] getTabela() {
		return tabela;
	}

	public void setTabela(Item[] tabela) {
		this.tabela = tabela;
	}
	
	public boolean inserir(String chave, String valor) {
		if(tamanho == tabela.length || buscar(chave) != null)
			return false;

		int inicio = hash(chave);
		int i = 0;
		
		while(tabela[(inicio+i) % tabela.length] != null 
				&& tabela[(inicio+i) % tabela.length].getChave() != chave)
			i++;

        tabela[(inicio + i) % tabela.length] = new Item(chave, valor);
        tamanho++;
        return true;
	}
	
	public boolean remover(String elemento){
		Item item = buscar(elemento);
       
        if (item == null) return false;
        
        item.setChave(null);
        item.setValor(null);
        
        tamanho--;
        return true;
	}
	
	public Item buscar(String elemento) {
		if(elemento == null) return null;
		
		int i = 0;
		int inicio = hash(elemento); // posição inicial
		
		while(i < tabela.length &&
				tabela[(inicio+i) % tabela.length] != null 
				&& (tabela[(inicio+i) % tabela.length].getChave() != null) 
				&& !tabela[(inicio+i) % tabela.length].getChave().equals(elemento))
			i++;
		Item retorno = tabela[(inicio+i) % tabela.length];
		
		if(retorno != null &&
				tabela[(inicio+i) % tabela.length].getChave() != null && 
				retorno.getChave().equals(elemento))
			return retorno;
		else
			return null;
	}
	
	public int hash(String chave) {
		int soma = 0;
		for(int i = 0; i<chave.length(); i++) {
			soma += chave.charAt(i);
		}
		return soma % tabela.length;
	}
	
	public void mostrar(){
		for(int i = 0; i < tabela.length; i++) {
			if(tabela[i] != null && tabela[i].getChave() != null) {
				System.out.println("Chave = " + tabela[i].getChave() + " || String armazenada na chave = " + tabela[i].getValor());
			}
		}
	}
}

/* Observações:
 * - Não pode inserir a mesma chave
 * - Não pode inserir strings com espaços em valor
 * 
 */
