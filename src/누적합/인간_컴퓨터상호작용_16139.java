package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 인간_컴퓨터상호작용_16139 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		String S = br.readLine(); // 문자열
		int q = Integer.parseInt(br.readLine()); // 질문 수
		int cnt = 0;
		
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			String temp = S.substring(l, r+1);
			char[] word = temp.toCharArray();
			
			for(char item : word) {
				if(a == item) cnt++;					
			}
			sb.append(cnt).append("\n");
			cnt = 0;
		}

		System.out.println(sb);

		
		
	}
}
