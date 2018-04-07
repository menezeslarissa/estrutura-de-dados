package testes.ordenacao.ed;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		int[] vetor = new int[5];
		
		try(Scanner scan = new Scanner(System.in)) {
			for(int i=0; i<vetor.length;i++) {
				System.out.println("Entre com um número inteiro: ");
				vetor[i] = scan.nextInt();
			}
			
			System.out.println("Vetor antes da ordenação InsertionSort: "+ Arrays.toString(vetor));
			
			for(int i=1; i<vetor.length;i++) {
				int eleito = vetor[i];
				int j = i -1;
				
				while(j>=0 && vetor[j]>eleito) {
					vetor[j+1] = vetor[j];
					j--;
				}
				
				vetor[j+1] = eleito;
			}
			
			System.out.println("Vetor depois da ordenação InsertionSort: " + Arrays.toString(vetor));
		}


	}

}
