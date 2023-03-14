package problems.category.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI_5525 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		
		String P = "IOI";
		
		for(int i = 0; i <= M-3; i++) {
			
			if(S.charAt(i) == 'O') continue;
			
			
			
			if(S.substring(i, i+3).equals(P)) {
				cnt++;
				i++;

				if(cnt >= N) { // 이어서 계속 갈 경우를 생각해라!! 
					result++;
					
				}
			}
			else {
				cnt = 0;
			}
			
			
		}
		
		System.out.println(result);
		
	}
}
/*
 * 한 칸씩 움직이면서 i면 검사 o면 통과
 */
