package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백123더하기_9095 {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			re(n);
			
			System.out.println(cnt);
			cnt = 0;
		}
		
		
	}
	
	
	public static void re(int n) {
		
		if(n == 0) {
			cnt++;
			return;
		}
		
		if(n-1 >= 0) {
			re(n-1);
		}
		
		if(n-2 >= 0) {
			re(n-2);
		}
		if(n-3 >= 0) {
			re(n-3);
		}
			
		
	}
	
}
