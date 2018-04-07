package testes.ordenacao.ed;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		int[] vetor = new int[5];
		
		try(Scanner scan = new Scanner(System.in)) {
			for(int i=0; i<vetor.length;i++) {
				System.out.println("Entre com um número inteiro: ");
				vetor[i] = scan.nextInt();
			}
			
			System.out.println("Vetor antes da ordenação SelectionSort: " + Arrays.toString(vetor));
			
			//selection sort
			for(int i=0; i<vetor.length-1; i++) {
				int eleito = vetor[i];
				int menor = vetor[i+1];
				int pos = i+1;
				//procura o menor a direita
				for(int j=i+2; j<vetor.length; j++) {
					if(vetor[j]<menor) {
						menor = vetor[j];
						pos = j;
					}
				}
				//comparações e troca
				if(menor<eleito) {
					vetor[i] = vetor[pos];
					vetor[pos]= eleito;
				}
			}
			
			System.out.println("Vetor depois da ordenação SelectionSort: " + Arrays.toString(vetor));
			
		}

	}

}
