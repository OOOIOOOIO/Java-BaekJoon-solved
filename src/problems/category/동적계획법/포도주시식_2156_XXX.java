package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_2156_XXX {
	static int n;
	static int[] dp;
	static int[] wine;
	
	static void check(int i) {
		if(n == i) {
			return;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n];
		wine = new int[n];
		
		for(int i = 0; i < n;  i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		
		
		
	}
}

/*

 1 2 3 4 5 6 7 8
 
 조건 
 3개 연속 X
  최대값
  
 재귀로 3개 연속된 수인지 알려면 흠흠 아니면 어떻게 해야 저렇게 되징
 Math.max(i + i+1) 0, 1 2 3 4 5 1 2 3 4 5 기준이 있어야될 것 같다.
 i + max(i+1) 2개 붙어서 그러면 다음번에는 i+3이 나와야 하는데
 Math.max(i+1, i+2)
 Math.max(i, i+2)
 값의 조합은 뭐가 있을까
 한 칸씩 띄어가는 것도 있고
 */
