package questao01;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Arvore arvore = new Arvore();
		int escolha;
		do {
			escolha = Menu(scan);
			if (escolha < 1 || escolha > 6)
				System.out.println("Op��o inv�lida!");
			else {
				System.out.println("-------------------------------\n\n");
				switch (escolha) {
				case 1:
					Estudante aluno = new Estudante();
					System.out.println("Chave do aluno: ");
					int chave = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Nome do aluno: ");
					String nome = scan.nextLine();
					aluno.setNome(nome);
					
					System.out.println("Matr�cula: ");
					String mat = scan.nextLine();
					aluno.setMatricula(mat);
					
					System.out.println("Posi��o no vestibular: ");
					int pos = scan.nextInt();
					aluno.setPos(pos);
					
					arvore.insere(chave, aluno);
					break;
				case 2:
					System.out.println("-----------------------------------------");
					System.out.println("Elementos em pr�-ordem...\n");
					arvore.mostraPreOrdem();
					break;
				case 3:
					System.out.println("-----------------------------------------");
					System.out.println("Elementos em p�s-ordem...\n");
					arvore.mostraPosOrdem();;
					break;
				case 4:
					System.out.println("-----------------------------------------");
					System.out.println("Elementos em ordem...\n");
					arvore.mostraOrdem();
					break;
				}
			}
		} while (escolha != 5);

	}
	public static int Menu(Scanner scan) {
		System.out.println("\nMENU");
		System.out.println("1 - Inserir na �rvore");
		System.out.println("2 - Mostrar elementos em pr�-ordem");
		System.out.println("3 - Mostrar elemntos em p�s-ordem");
		System.out.println("4 - Mostrar elementos em ordem");
		System.out.println("5 - Sair");
		System.out.println("\nDigite sua op��o:");
		int op = scan.nextInt();
		return op;
	}

}
