package problems.category.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5_10870_O {
	
	public static int pivo(int n) {
		if(n == 0) return 0;
        if(n <= 2) return 1; // if(n == 1) return 1;도 가능 
		
		return pivo(n-1) + pivo(n-2);
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(pivo(n));
		
	}
}
