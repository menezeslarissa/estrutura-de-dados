package questao0;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Arvore arvore = new Arvore();
		int escolha;
		do {
			escolha = Menu(scan);
			if (escolha < 1 || escolha > 6)
				System.out.println("Opção inválida!");
			else {
				System.out.println("-------------------------------\n\n");
				switch (escolha) {
				case 1:
					System.out.println("Código do produto [chave]: ");
					int chave = scan.nextInt();
					scan.nextLine();
					System.out.println("Nome do produto: ");
					String nome = scan.nextLine(); 
					System.out.println("Valor do produto: ");
					double valor = scan.nextDouble();
					System.out.println("Quantidade em estoque: ");
					int qtd = scan.nextInt();
					arvore.insere(chave, nome, valor, qtd);
					break;
				case 2:
					System.out.println("-----------------------------------------");
					System.out.println("PRODUTOS EM ESTOQUE\n");
					arvore.mostraOrdem();
					break;
				case 3:
					System.out.println("Digite o código do produto [chave] que deseja remover: ");
					chave = scan.nextInt();
					NoArvore no = arvore.busca(chave);
					arvore.remove(no);
					break;
				case 4:
					System.out.println("Quantidade total de produtos em estoque: " + arvore.mostrarTotalEstoque());
					System.out.println("Quantidade de produtos inseridos na árvore [Nó]: " + arvore.tamanho());
					break;
				case 5:
					System.out.println("Valor geral dos produtos em estoque: " + arvore.mostrarValorGeral());
					break;
				}
			}
		} while (escolha != 6);

	}
	public static int Menu(Scanner scan) {
		System.out.println("\nMENU");
		System.out.println("1 - Inserir produto");
		System.out.println("2 - Mostrar produtos");
		System.out.println("3 - Excluir produto");
		System.out.println("4 - Mostrar quantidade de produtos estocados");
		System.out.println("5 - Mostrar total geral do valor dos produtos");
		System.out.println("6 - Sair");
		System.out.println("\nDigite sua opção:");
		int op = scan.nextInt();
		return op;
	}
}


 /* Observações: - Se colocar a mesma chave, mas com valores de produto diferente, ele vai substituir o antigo pelo novo
  * - Em quantidade total de produtos devo retornar a quantidade de nós ou a quantidade de produtos estocados? 
  */
