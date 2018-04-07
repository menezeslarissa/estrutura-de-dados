package questao03;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		HashEncad hash = new HashEncad(100);
		Scanner scan = new Scanner(System.in);
		int escolha;
		do {
			escolha = Menu(scan);
			if (escolha < 1 || escolha > 4)
				System.out.println("Op��o inv�lida!");
			else {
				System.out.println("-------------------------------\n\n");
				switch (escolha) {
				case 1:
					System.out.println("Insira a chave: ");
					String chave = scan.next();
					System.out.println("Insira a string que deseja armazenar na chave: ");
					String valor = scan.next(); // n�o inserir string com espa�os
					boolean success = hash.insere(chave, valor);
					if(success == false)
						System.out.println("Chave n�o inserida, pois a mesma j� foi inserida ou tabela est� cheia!");
					break;
				case 2:
					hash.imprime();
					System.out.println("\n");
					break;
				case 3:
					System.out.println("Digite o chave que deseja remover: ");
					chave = scan.next();
					hash.remove(chave);
					break;
				}
			}
		} while (escolha != 4);

	}

	public static int Menu(Scanner scan) {
		System.out.println("\nMENU");
		System.out.println("1 - Inserir elemento");
		System.out.println("2 - Mostrar tabela");
		System.out.println("3 - Excluir elemento");
		System.out.println("4 - Sair");
		System.out.println("Digite sua op��o:");
		int op = scan.nextInt();
		return op;
	}

}
