
package testes.ordenacao.ed;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			int[] vetor = new int[5];	
			
			for(int i=0;i<vetor.length;i++) {
				System.out.println("Entre com um número inteiro: ");
				vetor[i] = scan.nextInt(); 
			}
			
			System.out.println("Vetor antes da ordenação BubbleSort: " + Arrays.toString(vetor));
			
			for(int i = 0; i<vetor.length; i++) {
				for(int j = 0; j<vetor.length-1; j++) {
					if(vetor[j]>vetor[j+1]) { 
						int aux = vetor[j];
						vetor[j] = vetor[j+1];
						vetor[j+1] = aux;		
					}
				}
			}
			
			System.out.println("Vetor depois da ordenação BubbleSort: " + Arrays.toString(vetor));
		}

	}
}
