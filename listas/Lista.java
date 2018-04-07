package lista;

import java.lang.reflect.Array;

//<> operador conhecido como diamond
@SuppressWarnings("unused")
public class Lista<T> { //class Type
	// usar Generics para na hora da declaração do vetor passar qual tipo de classe que queremos q esse vetor trabalh
		private T[] elementos;
		private int tamanho; // indicar tamanho real do vetor
		
		//instanciando um vetor dinamicamente
		/*public Lista(int capacidade, Class<T> tipoClasse) {
			this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
			this.tamanho = 0;
		}*/
		//construtor de tipos genericos de uma forma mais clean
		@SuppressWarnings("unchecked")
		public Lista(int capacidade) {
			this.elementos = (T[]) new Object[capacidade];
			this.tamanho = 0;
		}
		
		// método para aumentar a capacidade do vetor
		// faz casting
		private void aumentaCapacidade() {
			if (this.tamanho == this.elementos.length) {
				@SuppressWarnings("unchecked")
				T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
				for (int i = 0; i < this.elementos.length; i++) {
					elementosNovos[i] = this.elementos[i];
				}
				this.elementos = (T[]) elementosNovos; // atribuindo o novo vetor ao vetor antigo q está em uso
			}
		}
		
		
		// método adiciona opcao 2; melhor opção
		public boolean adiciona(T elemento){
			this.aumentaCapacidade();
			if(this.tamanho < this.elementos.length){
				this.elementos[this.tamanho] = elemento;
				this.tamanho++;
				return true;
			} 
			return false;
		}
		//método para adicionar elemento em qualquer posição do vetor
		
		public boolean adiciona(int posicao, T elemento ){
			this.aumentaCapacidade();
			//verificar se a posicao que o usuário está passando é válida
			if (!(posicao >= 0 && posicao < tamanho)) { // negando as posições que existem no vetor e indicando a posições que NAO podem ser acessadas
				throw new IllegalArgumentException("Posição inválida!");    // exception p tipos de argumentos inválidos								 
			}
			// movendo todos os elementos
			for(int i = this.tamanho-1; i>=posicao; i--){
				this.elementos[i+1] = this.elementos[i];
			}
			this.elementos[posicao] = elemento;
			this.tamanho++;
			return true;
		}
		
		// método que retorna o tamanho do vetor
		public int tamanho(){
			return this.tamanho;
		}
		// imprimir todos os elementos do vetor
		@Override
		public String toString() {
			// classe do java para concatenação de strings
			StringBuilder s = new StringBuilder();
			s.append("\n"); // append adiciona string no string builder

			for (int i = 0; i < this.tamanho - 1; i++) { //até a - 1(penultima pos) para pode fechar com colchetes
				s.append(this.elementos[i]);
				s.append(""); // colocar a string q deseja dicionar c o método
								// append
			}

			if (this.tamanho > 0) { // para evitar exception
				s.append(this.elementos[this.tamanho - 1]);
			}
		 	s.append("\n\n");

			return s.toString();
		}
		
		// método de busca; obter elemento de determinada posição
		public Object busca(int posicao) {
			if (!(posicao >= 0 && posicao < tamanho)) { // negando as posições que existem no vetor e indicando a posições que NAO podem ser acessadas
					throw new IllegalArgumentException("Posição inválida!");    // exception p tipos de argumentos inválidos								 
			}
			// se n for inválida, retorna o elemento desejado
			return this.elementos[posicao];
		}
		
		// método para verificar se um dterminado elemento existe
		// busca sequencial; ler posicao por posicao
		// pode ser boolean tbm
		public int busca(T elemento) {
			for (int i = 0; i < this.tamanho; i++) {
				if (this.elementos[i].equals(elemento)) { // não importa a classe, o equals é válido
					return i; // se existir                                         
				}
			}
			return -1; // posição que não existe
		}
		
		public boolean contem(T elemento) {	
			//se for vdd retorna true
			return busca(elemento) > - 1;// >=0
			
		}
		
		
		//remove um elemento de uma determinada posição
		public void remove(int posicao) {
			if (!(posicao >= 0 && posicao < tamanho)) {
				throw new IllegalArgumentException("Posição inválida!");
			}

			for (int i = posicao; i < tamanho - 1; i++) {
				elementos[i] = elementos[i + 1];
			}

			tamanho--;
		}
}
