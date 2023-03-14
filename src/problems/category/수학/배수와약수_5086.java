package problems.category.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배수와약수_5086 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 종료
			if(a == 0 && b == 0) break;
			
			//배수
			if(a > b) {
				if(a % b == 0) sb.append("multiple").append("\n");
				else sb.append("neither").append("\n");
			}
			// 약수
			else {
				if(b % a == 0) sb.append("factor").append("\n");
				else sb.append("neither").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
