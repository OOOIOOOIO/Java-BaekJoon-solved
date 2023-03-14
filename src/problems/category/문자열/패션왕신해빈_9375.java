package problems.category.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 패션왕신해빈_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			int result = 1;
			while(n-- > 0) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				
				map.put(kind, map.getOrDefault(kind, 0)+1);
				
			}
			
			for(int value : map.values()) {
				result *= (value+1); // 옷을 안입는 경우의 수 추가
			}
			sb.append(result-1).append("\n"); // 알몸인 경우 빼기 
			
		}
		
		System.out.println(sb.toString());
	}
	
}
