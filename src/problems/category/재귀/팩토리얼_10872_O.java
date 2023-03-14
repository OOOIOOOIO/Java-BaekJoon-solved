package problems.category.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼_10872_O {
	
	public int fact(int N) { // static 붙여서 그냥 사용도 해보기
		if(N <= 1) { // N == 1로 하면 백준에서 stackoverflow 발생 
			return 1;
		}
		
		return N * fact(N-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		팩토리얼_10872_O test = new 팩토리얼_10872_O();
		
		System.out.println(test.fact(N));
		
		
	
	}
}
