package testes.ordenacao.ed;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		int[] vetor = new int[5];
		int[] aux = new int[5];
		try(Scanner scan = new Scanner(System.in)) {
			
			for(int i=0; i<vetor.length; i++) {
				System.out.println("Entre com um número: ");
				vetor[i] = scan.nextInt();
			}
			
			System.out.println("Vetor antes da ordenação MergeSort: " + Arrays.toString(vetor));
			
			mergeSort(vetor, aux, 0, vetor.length-1);
			
			System.out.println("Vetor depois da ordenação MergeSort: " + Arrays.toString(vetor));
		}

	}

	private static void mergeSort(int[] vetor, int[] aux, int ini, int fim) {
		if(ini<fim) {
			int meio = (ini+fim)/2;
			mergeSort(vetor, aux, ini, meio);
			mergeSort(vetor, aux, meio+1, fim);
			intercalar(vetor, aux, ini, meio, fim);
		}
		
	}

	private static void intercalar(int[] vetor, int[] aux, int ini, int meio, int fim) {
		for(int k = ini; k<= fim; k++) 
			aux[k]=vetor[k];
		
		int i = ini;
		int j = meio+1;
		
		for(int k=ini; k<=fim; k++) {
			if(i>meio) vetor[k] = aux[j++];
			else if(j>fim) vetor[k] = aux[i++];
			else if(aux[i] < aux[j]) vetor[k] = aux[i++];
			else vetor[k] = aux[j++];
		}
	}

}
