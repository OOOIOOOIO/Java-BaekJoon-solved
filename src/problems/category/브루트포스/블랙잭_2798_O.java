package problems.category.브루트포스;

import java.util.Scanner;

public class 블랙잭_2798_O {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;
		int sum = 0;
		int[] data = new int[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+2; k <N; k++) {
					sum = data[i] + data[j] + data[k];
					if(sum > max & sum <= M) max = sum;
					
				}
			}
			
		}
		
		System.out.println(max);
	
	}
}
