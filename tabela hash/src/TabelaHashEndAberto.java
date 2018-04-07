
public class TabelaHashEndAberto {
	private Item[] tabela; // tabela contendo os itens; item nulo indica posição livre
	private int tamanho;
	
	public TabelaHashEndAberto(int maxTam) {
		tabela = new Item[maxTam]; // inicializa a tabela
	}
	
	public int tamanho() {
		return tamanho; 
	}
	
	public void imprime() {
		for(int i = 0; i<tabela.length; i++) { // para cada item da tabela
			if(tabela[i] != null && tabela[i].getChave() != null) { // se existe e n foi apagado
				System.out.println(tabela[i].getChave() + " = " + tabela[i].getValor());
			} // imprime a chave e o valor
		}
	}
	
	private int hash(String chave) {
		int soma = 0;
		
		for(int i = 0; i< chave.length(); i++) 
			soma += chave.charAt(i); // soma os caracteres de acordo c a tabela ascii
		
		return soma % tabela.length; //pega o resto com o tamanho máximo da tabela
	}

	public Item busca(String chave) {
		if(chave == null) return null; // elemento n existe

		int inicio = hash(chave); // posição inicial so item com base na função hash
		int i = 0;

		while(tabela[(inicio + i) % tabela.length] != null && 
				!tabela[(inicio + i) % tabela.length].getChave().equals(chave) 
				&& i<tabela.length) // enquanto existir item na posição mas a chave for diferente, tenta a
			// proxima posição, por sondagem linear
			i++;

		Item retorno = tabela[(inicio + i) % tabela.length];

		if(retorno != null && retorno.getChave().equals(chave))
			return retorno;
		else
			return null;

	}
	
	public boolean insere(String chave, Object valor) {
		if (tamanho == tabela.length || busca(chave) != null)
			return false; // atingiu o tamanho máx ou não aceita chaves repetidas

		int inicio = hash(chave);
		int i = 0;

		while (tabela[(inicio + i) % tabela.length] != null && tabela[(inicio + i) % tabela.length].getChave() != null)
			i++;
		// enquanto existir item numa posiçãp que não tenha sido removido(colisao),
		// tenta o próximo

		tabela[(inicio + i) % tabela.length] = new Item(chave, valor); // insere item
		tamanho++;
		return true;
	}
	
	public boolean remove(String chave){
		Item item = (Item) busca(chave);
		
		if(item == null) return false; // item não foi encontrado
		
		item.setChave(null);
		item.setValor(null);
		
		tamanho--;
		return true;
	}
	
}
