package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카잉달력 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = M * N / gcd(M, N);
			int digit = 0;
			int ans = -1;
			
			while(digit * M < lcm) {
				
				if((M * digit + x - y) % N == 0){
					ans = M * digit + x;
					break;
				}
				digit++;
			}
			
			System.out.println(ans);
		
		}
		
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		
		else return gcd(b, a % b);
	}
}
