package questao03;


public class HashEncad {
	private ItemNo[] tabela;
	private int tamanho;
	
	public HashEncad(int maxTam){
		tabela = new ItemNo[maxTam];
	}
	
	public int tamanho(){
		return tamanho;
	}
	
	public void imprime(){
		for(int i = 0; i<tabela.length; i++){
			for(ItemNo atual= tabela[i]; atual!=null; atual = atual.getProx()){ // percorre a lista
				System.out.println("Chave = " + atual.getChave() + " || Conteúdo armazenado na chave = " + atual.getValor());
			}
		}
	}
	
	public int hash(String chave){
		int soma = 0;
		for(int i =0; i<chave.length(); i++){
			soma+=chave.charAt(i);
		}
		return soma%tabela.length; 
	}
	
	
	public ItemNo busca(String chave){
		if(chave == null) return null;
		
		for(ItemNo retorno = tabela[hash(chave)]; retorno !=null; retorno = retorno.getProx()){
			if(retorno.getChave().equals(chave) && retorno.getChave() != null && retorno.getChave().equals(chave)){
				return retorno;
			}
		}
		return null;
	}
	
	public boolean insere(String chave, String valor){
		if(busca(chave) != null || tamanho == tabela.length) return false;
		
		int indice = hash(chave);
		ItemNo topo = tabela[indice];
		tabela[indice] = new ItemNo(chave, valor);
		tabela[indice].setProx(topo);
		tamanho++;
		return true;
	}
	
	public boolean remove(String chave){
		int indice = hash(chave);
		
		ItemNo noAtual = tabela[indice];
		ItemNo noAnterior = null;
		while(noAtual != null && !noAtual.getChave().equals(chave)){
			noAnterior = noAtual;
			noAtual = noAtual.getProx();
		}
		
		if(noAtual == null) return false;
		
		if(noAtual == tabela[indice]){
			tabela[indice] = tabela[indice].getProx();
		} else{
			noAnterior.setProx(noAtual.getProx());
		}
		tamanho--;
		return true;
	}
}
