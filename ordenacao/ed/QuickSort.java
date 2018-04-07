package testes.ordenacao.ed;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		int[] vetor = new int[5];
		
		try(Scanner scan = new Scanner(System.in)) {
			for(int i = 0; i<vetor.length; i++) {
				System.out.println("Entre com um número inteiro: ");
				vetor[i] = scan.nextInt();
			}
			
			quickSort(vetor, 0, vetor.length-1);
			System.out.println(Arrays.toString(vetor));
			
		}

	}
	
	private static void quickSort(int[] v, int ini, int fim) {
		if(ini<fim) {
			int j = separar(v, ini, fim);
			quickSort(v, ini, j-1);
			quickSort(v, j+1, fim);
		}
	}

	private static int separar(int[] v, int esq, int dir) {
		int i = esq, j = dir;
		int pivo = v[(esq+dir)/2];
		while(i<j) {
			while(i<dir && v[i]<=pivo) i++;
			while(j>esq && v[j]>= pivo) j--;
			if(i<j) {
				troca(v, i, j);
				i++;
				j--;
			}
		}
		troca(v, esq, j);
		return pivo;
	}
	
	private static void troca(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
	
	
}
